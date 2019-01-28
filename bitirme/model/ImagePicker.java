package com.android.bitirme.model;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import com.example.samet.anasayfa.BuildConfig;
import com.example.samet.anasayfa.R;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * BU SINIF YARDIMCI SINIFTIR İNTERNETETN ALINMIŞTIR
 */


public final class ImagePicker {

    private static final int DEFAULT_REQUEST_CODE = 234;

    private static final int DEFAULT_MIN_WIDTH_QUALITY = 400;        // min pixels
    private static final int DEFAULT_MIN_HEIGHT_QUALITY = 400;        // min pixels
    private static final String TAG = ImagePicker.class.getSimpleName();

    private static int minWidthQuality = DEFAULT_MIN_WIDTH_QUALITY;
    private static int minHeightQuality = DEFAULT_MIN_HEIGHT_QUALITY;

    private static String mChooserTitle;
    private static int mPickImageRequestCode = DEFAULT_REQUEST_CODE;
    private static boolean mGalleryOnly = false;

    private ImagePicker() {
        // not called
    }


    public static void pickImage(Activity activity, int requestCode) {
        pickImage(activity, activity.getString(R.string.pick_image_intent_text), requestCode, false);
    }


    public static void pickImage(Activity activity) {
        pickImage(activity, activity.getString(R.string.pick_image_intent_text), DEFAULT_REQUEST_CODE, false);
    }


    public static void pickImage(Fragment fragment, int requestCode) {
        pickImage(fragment, fragment.getString(R.string.pick_image_intent_text), requestCode, false);
    }


    public static void pickImage(Fragment fragment) {
        pickImage(fragment, fragment.getString(R.string.pick_image_intent_text), DEFAULT_REQUEST_CODE, false);
    }


    public static void pickImageGalleryOnly(Activity activity, int requestCode) {
        pickImage(activity, activity.getString(R.string.pick_image_intent_text), requestCode, true);

    }


    public static void pickImageGalleryOnly(Fragment fragment, int requestCode) {
        pickImage(fragment, fragment.getString(R.string.pick_image_intent_text), requestCode, true);
    }


    public static void pickImage(Activity activity, String chooserTitle) {
        pickImage(activity, chooserTitle, DEFAULT_REQUEST_CODE, false);
    }


    public static void pickImage(Fragment fragment, String chooserTitle) {
        pickImage(fragment, chooserTitle, DEFAULT_REQUEST_CODE, false);
    }


    public static void pickImage(Fragment fragment, String chooserTitle,
                                 int requestCode, boolean galleryOnly) {
        mGalleryOnly = galleryOnly;
        mPickImageRequestCode = requestCode;
        mChooserTitle = chooserTitle;
        startChooser(fragment);
    }


    public static void pickImage(Activity activity, String chooserTitle,
                                 int requestCode, boolean galleryOnly) {
        mGalleryOnly = galleryOnly;
        mPickImageRequestCode = requestCode;
        mChooserTitle = chooserTitle;
        startChooser(activity);
    }

    private static void startChooser(Fragment fragmentContext) {
        Intent chooseImageIntent = getPickImageIntent(fragmentContext.getContext(), mChooserTitle);
        fragmentContext.startActivityForResult(chooseImageIntent, mPickImageRequestCode);
    }

    private static void startChooser(Activity activityContext) {
        Intent chooseImageIntent = getPickImageIntent(activityContext, mChooserTitle);
        activityContext.startActivityForResult(chooseImageIntent, mPickImageRequestCode);
    }


    public static Intent getPickImageIntent(Context context, String chooserTitle) {
        Intent chooserIntent = null;
        List<Intent> intentList = new ArrayList<>();

        Intent pickIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intentList = addIntentsToList(context, intentList, pickIntent);

        if (!mGalleryOnly) {

            if (!appManifestContainsPermission(context, Manifest.permission.CAMERA) || hasCameraAccess(context)) {
                Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                takePhotoIntent.putExtra("return-data", true);
                takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider",
                                ImageUtils.getTemporalFile(context, String.valueOf(mPickImageRequestCode))));
                //Uri.fromFile(ImageUtils.getTemporalFile(context, String.valueOf(mPickImageRequestCode))));
                intentList = addIntentsToList(context, intentList, takePhotoIntent);
            }
        }

        if (intentList.size() > 0) {
            chooserIntent = Intent.createChooser(intentList.remove(intentList.size() - 1),
                    chooserTitle);
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
                    intentList.toArray(new Parcelable[intentList.size()]));
        }

        return chooserIntent;
    }

    private static List<Intent> addIntentsToList(Context context, List<Intent> list, Intent intent) {
        Log.i(TAG, "Adding intents of type: " + intent.getAction());
        List<ResolveInfo> resInfo = context.getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo resolveInfo : resInfo) {
            String packageName = resolveInfo.activityInfo.packageName;
            Intent targetedIntent = new Intent(intent);
            targetedIntent.setPackage(packageName);
            list.add(targetedIntent);
            Log.i(TAG, "App package: " + packageName);
        }
        return list;
    }

    /**
     * Checks if the current context has permission to access the camera.
     * @param context             context.
     */
    private static boolean hasCameraAccess(Context context) {
        return ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Checks if the androidmanifest.xml contains the given permission.
     * @param context             context.
     * @return Boolean, indicating if the permission is present.
     */
    private static boolean appManifestContainsPermission(Context context, String permission) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            String[] requestedPermissions = null;
            if (packageInfo != null) {
                requestedPermissions = packageInfo.requestedPermissions;
            }
            if (requestedPermissions == null) {
                return false;
            }

            if (requestedPermissions.length > 0) {
                List<String> requestedPermissionsList = Arrays.asList(requestedPermissions);
                return requestedPermissionsList.contains(permission);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Called after launching the picker with the same values of Activity.getImageFromResult
     * in order to resolve the result and get the image path.
     *
     * @param context             context.
     * @param requestCode         used to identify the pick image action.
     * @param resultCode          -1 means the result is OK.
     * @param imageReturnedIntent returned intent where is the image data.
     * @return path to the saved image.
     */
    @Nullable
    public static String getImagePathFromResult(Context context, int requestCode, int resultCode,
                                                Intent imageReturnedIntent) {
        Log.i(TAG, "getImagePathFromResult() called with: " + "resultCode = [" + resultCode + "]");
        Uri selectedImage = null;
        if (resultCode == Activity.RESULT_OK && requestCode == mPickImageRequestCode) {
            File imageFile = ImageUtils.getTemporalFile(context, String.valueOf(mPickImageRequestCode));
            boolean isCamera = (imageReturnedIntent == null
                    || imageReturnedIntent.getData() == null
                    || imageReturnedIntent.getData().toString().contains(imageFile.toString()));
            if (isCamera) {
                return imageFile.getAbsolutePath();
            } else {
                selectedImage = imageReturnedIntent.getData();
            }
            Log.i(TAG, "selectedImage: " + selectedImage);
        }
        if (selectedImage == null) {
            return null;
        }
        return getFilePathFromUri(context, selectedImage);
    }

    /**
     * Get stream, save the picture to the temp file and return path.
     *
     * @param context context
     * @param uri uri of the incoming file
     * @return path to the saved image.
     */
    private static String getFilePathFromUri(Context context, Uri uri) {
        InputStream is = null;
        if (uri.getAuthority() != null) {
            try {
                is = context.getContentResolver().openInputStream(uri);
                Bitmap bmp = BitmapFactory.decodeStream(is);
                return ImageUtils.savePicture(context, bmp, String.valueOf(uri.getPath().hashCode()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Called after launching the picker with the same values of Activity.getImageFromResult
     * in order to resolve the result and get the input stream for the image.
     *
     * @param context             context.
     * @param requestCode         used to identify the pick image action.
     * @param resultCode          -1 means the result is OK.
     * @param imageReturnedIntent returned intent where is the image data.
     * @return stream.
     */
    public static InputStream getInputStreamFromResult(Context context, int requestCode, int resultCode,
                                                       Intent imageReturnedIntent) {
        Log.i(TAG, "getFileFromResult() called with: " + "resultCode = [" + resultCode + "]");
        if (resultCode == Activity.RESULT_OK && requestCode == mPickImageRequestCode) {
            File imageFile = ImageUtils.getTemporalFile(context, String.valueOf(mPickImageRequestCode));
            Uri selectedImage;
            boolean isCamera = (imageReturnedIntent == null
                    || imageReturnedIntent.getData() == null
                    || imageReturnedIntent.getData().toString().contains(imageFile.toString()));
            if (isCamera) {     /** CAMERA **/
                //selectedImage = Uri.fromFile(imageFile);
                selectedImage = FileProvider.getUriForFile(context,
                        BuildConfig.APPLICATION_ID + ".provider", imageFile);
            } else {            /** ALBUM **/
                selectedImage = imageReturnedIntent.getData();
            }
            Log.i(TAG, "selectedImage: " + selectedImage);

            try {
                if (isCamera) {
                    // We can just open the temporary file stream and return it
                    return new FileInputStream(imageFile);
                } else {
                    // Otherwise use the ContentResolver
                    return context.getContentResolver().openInputStream(selectedImage);
                }
            } catch (FileNotFoundException ex) {
                Log.e(TAG, "Could not open input stream for: " + selectedImage);
                return null;
            }
        }
        return null;
    }

    /**
     * Loads a bitmap and avoids using too much memory loading big images (e.g.: 2560*1920)
     */
    private static Bitmap decodeBitmap(Context context, Uri theUri) {
        Bitmap outputBitmap = null;
        AssetFileDescriptor fileDescriptor = null;

        try {
            fileDescriptor = context.getContentResolver().openAssetFileDescriptor(theUri, "r");

            // Get size of bitmap file
            BitmapFactory.Options boundsOptions = new BitmapFactory.Options();
            boundsOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, boundsOptions);

            // Get desired sample size. Note that these must be powers-of-two.
            int[] sampleSizes = new int[]{8, 4, 2, 1};
            int selectedSampleSize = 1; // 1 by default (original image)

            for (int sampleSize : sampleSizes) {
                selectedSampleSize = sampleSize;
                int targetWidth = boundsOptions.outWidth / sampleSize;
                int targetHeight = boundsOptions.outHeight / sampleSize;
                if (targetWidth >= minWidthQuality && targetHeight >= minHeightQuality) {
                    break;
                }
            }

            // Decode bitmap at desired size
            BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
            decodeOptions.inSampleSize = selectedSampleSize;
            outputBitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor.getFileDescriptor(), null, decodeOptions);
            if (outputBitmap != null) {
                Log.i(TAG, "Loaded image with sample size " + decodeOptions.inSampleSize + "\t\t"
                        + "Bitmap width: " + outputBitmap.getWidth()
                        + "\theight: " + outputBitmap.getHeight());
            }
            fileDescriptor.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputBitmap;
    }


    /*
    GETTERS AND SETTERS
     */

    public static void setMinQuality(int minWidthQuality, int minHeightQuality) {
        ImagePicker.minWidthQuality = minWidthQuality;
        ImagePicker.minHeightQuality = minHeightQuality;
    }
}
