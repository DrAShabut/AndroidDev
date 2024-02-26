# Android Multimedia Framework and JetPack Media 3
![image](uploads/7e766148270fd32ad121f48164e0b921/image.png)


This Tutorial shows you how to write a media-playing app that interacts with the user and the system to get good performance and a pleasant user experience. It also looks at how to use the camera hardware to capture images, and record videos using the new CameraX app.


# Exercise 1: MediaPlayer APIs to play a sound file.
Create a new project in Android Studio and call it MediaPlayer. Use the default options and select Empty Views Activity when prompted for Activity Type. We will also need a sound for this exercise and will use the same longer playing "water" sound from:http://soundbible.com/2032-Water.html

# How to do it ...
As explained previously, we will need a sound file to include in the project. Once you have your sound file ready, follow these steps:

1.	Create a new raw folder (File | New | Android resource directory). Choose raw in the Resource type dropdown and then click the Ok button.

![image](uploads/16b92a9871c16320bef67420dd6f68c8/image.png)

 
2.	Copy your sound file to res/raw as sound_1, (keep the original extension).
3.	Open activity_main.xml and replace the existing TextView with the following design:

![image](uploads/ff75a7dc4ee95ee163ef600282c90439/image.png)  

4.	Add the android:onClick="buttonPlay" for button PLAY and android:onClick="buttonPause" for button PAUSE and android:onClick="buttonStop" for button STOP.

5.	Now, open ActivityMain.java and add the following class variable:
```java
MediaPlayer mMediaPlayer;
```
6.	Add the buttonPlay() method:
```java
public void buttonPlay(View view){
    if (mMediaPlayer==null) {
        mMediaPlayer = MediaPlayer.create(this, R.raw.sound_1);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    } else  {
        mMediaPlayer.start();
    }
}
```
7.	Add the buttonPause() method:
```java
public void buttonPause(View view){
    if (mMediaPlayer!=null && mMediaPlayer.isPlaying()) {
        mMediaPlayer.pause();
    }
}
```
8.	Add the buttonStop() method:
```java
public void buttonStop(View view){
    if (mMediaPlayer!=null) {
        mMediaPlayer.stop();
        mMediaPlayer.release();
        mMediaPlayer = null;
    }
}
```
9.	Finally, override the onStop() callback with the following code:
```java
@Override
protected void onStop() {
    super.onStop();
    if (mMediaPlayer!=null) {
        mMediaPlayer.release();
        mMediaPlayer = null;
    }
}
```
10.	You can run the application on a device or emulator.

# There's more...
Using a short audio file included with the project, we aren't likely to experience any UI delays. Generally, using a background thread when preparing MediaPlayer is a good idea. To make this common task easier, MediaPlayer already includes an asynchronous preparation method called prepareAsync(). The following code will create an OnPreparedListener() listener and use the prepareAsync() method:
```java
mMediaPlayer = new MediaPlayer();
mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
    @Override
    public void onPrepared(MediaPlayer mp) {
        mMediaPlayer.start();
    }
});
try {
    mMediaPlayer.setDataSource(/*URI, URL or path here*/));
} catch (IOException e) {
    e.printStackTrace();
}
mMediaPlayer.prepareAsync();
```
To do this step, replace the code in buttonPlay with the code above. the method buttonPlay should look like the following:
```java
public void buttonPlay(View view) {
    Uri mediaPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sound_1);
    mMediaPlayer = new MediaPlayer();
    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mMediaPlayer.start();
        }
    });
    try {
        mMediaPlayer.setDataSource(getApplicationContext(), mediaPath);
    } catch (IOException e) {
        e.printStackTrace();
    }
    mMediaPlayer.prepareAsync();
}
```
## Using hardware volume keys to control your app's audio volume

If you want the volume controls to control the volume in your app, add the setVolumeControlStream() method to your onCreate() method to specify your application's audio stream, as follows:
```java
setVolumeControlStream(AudioManager.STREAM_MUSIC);
``` 
![image](uploads/0944d4962da7740ff42f506c0974be98/image.png)

See the AudioManager [link](https://developer.android.com/reference/android/media/AudioManager) for other streaming options.

# Exercise 2: Video Playback on Android using the VideoView and MediaController Classes

1.	Create a new empty activity in the same project above and call it VideoPlayerActivity.

2.	Open the activity_video_player.xml Layout and from the Widgets category of the Palette panel, drag and drop a VideoView instance onto the layout so that it fills the available canvas area, as follows: 

![image](uploads/6c874434d074a971df59a5dcaf1577d1/image.png)
 
Using the Attributes panel, change the layout_width and layout_height attributes to match_constraint and wrap_content respectively. Also, remove the constraint connecting the bottom of the VideoView to the bottom of the parent ConstraintLayout. 

3.	Download the Video File from [Google](http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4) and add it to the raw directory created in the previous example.

4.	The next step is to configure the VideoView with the path of the video to be played and then start the playback. This will be performed when the VideoPlayerActivity has been initialised, so load the VideoPlayerActivity.java file into the editor and modify it as outlined in the following listing:
```java
public class VideoPlayerActivity extends AppCompatActivity {
    private VideoView videoView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        configureVideoView();
    }
    private void configureVideoView() {
        videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://"
                + getPackageName() + "/" + R.raw.movie));
        videoView.start();
    }
}
```
5.	Now Add a button to the activity_main.xml. Start VideoPlayerActivity from the main activity using intent and run your app.

![image](uploads/e4624e31852d4ea0e25e3fb10cbbdba3/image.png)

6.	As the VideoPlayer application currently stands, there is no way for the user to control playback. As previously outlined, this can be achieved using the MediaController class. To add a controller to the VideoView, modify the configureVideoView() method once again. The final code should look like the following:
```java
public class VideoPlayerActivity extends AppCompatActivity {
    private VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        configureVideoView();
    }
    private void configureVideoView() {
        final VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://"
                + getPackageName() + "/" + R.raw.movie));
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
```
When the application is launched with these changes implemented, tapping the VideoView canvas will cause the media controls to appear over the video playback. These controls should include a seekbar together with fast forward, rewind and play/pause buttons. After the controls recede from view, they can be restored at any time by tapping on the VideoView canvas once again. With just three more lines of code, our video player application now has media controls as shown in the following figure:

![image](uploads/f1e9036488a96d04acc038ad8d013c17/image.png)
 
7.	Now set up the onPreparedListener as in the previous example by changing the existing code with the following one:
```java
public class VideoPlayerActivity extends AppCompatActivity {
    private VideoView videoView;
    private MediaController mediaController;
    String TAG = "VideoPlayer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        configureVideoView();
    }
    private void configureVideoView() {
        final VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://"
                + getPackageName() + "/" + R.raw.movie));
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                Log.i(TAG, "Duration = " + videoView.getDuration());
            }
        });
        videoView.start();
    }
}
```
8.	Now rerun your application.

# Exercise 3: MediaPlayer app using Media3 ExpoPlayer APIs
Create a new project in Android Studio and call it ExpoPlayer. Use the default options and select Empty Views Activity when prompted for Activity Type.
1. Add Dependencies, make sure you have the necessary dependencies in your build.gradle file. Add the following lines to your app-level build.gradle:
 
```XML
implementation ("androidx.media3:media3-exoplayer:1.2.1")
implementation ("androidx.media3:media3-ui:1.2.1")
implementation ("androidx.media3:media3-common:1.2.1")
```

2. Create an ExoPlayer Instance, in your Java class, create an instance of SimpleExoPlayer:

```Java
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class MainActivity extends AppCompatActivity {
    private SimpleExoPlayer exoPlayer;
    private PlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ExoPlayer
        exoPlayer = new SimpleExoPlayer.Builder(this).build();

        // Find the PlayerView in your layout
        playerView = findViewById(R.id.exoPlayerView);
        playerView.setPlayer(exoPlayer);

        // Create a MediaItem (replace the URL with your audio/video source)
        Uri mediaUri = Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        MediaItem mediaItem = MediaItem.fromUri(mediaUri);

        // Add the MediaItem to the player
        exoPlayer.setMediaItem(mediaItem);

        // Prepare the player (load media and acquire resources)
        exoPlayer.prepare();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the player when no longer needed
        exoPlayer.release();
    }
}
```
3. Go to your activity_main.xml code and add a PlayerView to display the video and audio controls using the following code:

```XML
<!-- res/layout/activity_media_player.xml -->
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <com.google.android.exoplayer2.ui.PlayerView
        android:id="@+id/exoPlayerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</FrameLayout>
```
4. Permissions, don’t forget to add the necessary permissions for internet access in your AndroidManifest.xml:

```XML

<uses-permission android:name="android.permission.INTERNET" />
```
5. Run Your App, build and run your app. You should see the video playing in the PlayerView.

Task: Replace the sample URL (http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4) with your actual audio or video source URL.

# Exercise 4: Take a photo using the CameraX library
CameraX is a powerful Jetpack library that simplifies integrating the device camera into your Android app. It provides a consistent camera experience across different devices. Let’s walk through the steps to take a photo using CameraX:

1. Add Dependencies, in your app-level build.gradle file, add the following dependency:
```XML
implementation "androidx.camera:camera-camera2:1.1.0"
```

2. Set Up CameraX, initialise CameraX in your Activity:

```Java
import androidx.camera.core.CameraX;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.lifecycle.LifecycleOwner;

// ...

// Inside your activity
PreviewView previewView = findViewById(R.id.previewView); // Your preview view
LifecycleOwner lifecycleOwner = this; // Use your lifecycle owner

// Initialize CameraX
ProcessCameraProvider cameraProvider = ProcessCameraProvider.getInstance(this);
cameraProvider.addListener(() -> {
    try {
        // Set up the preview use case
        Preview preview = new Preview.Builder().build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        // Bind the preview use case to the lifecycle
        cameraProvider.bindToLifecycle(lifecycleOwner, preview);
    } catch (Exception e) {
        // Handle exceptions
    }
});
```
3. Capture a Photo, to capture a photo, you’ll need to add an image capture use case. Here’s how you can do it:

```Java
import androidx.camera.core.ImageCapture;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// ...

// Inside your activity
ExecutorService executor = Executors.newSingleThreadExecutor();
ImageCapture imageCapture = new ImageCapture.Builder().build();

// Capture a photo
File outputFile = new File(getExternalFilesDir(null), "my_photo.jpg");
imageCapture.takePicture(outputFile, executor,
    new ImageCapture.OnImageSavedCallback() {
        @Override
        public void onImageSaved(File file) {
            // Photo saved successfully
        }

        @Override
        public void onError(ImageCaptureException exception) {
            // Handle capture error
        }
    });
```
4. Permissions, don’t forget to add the necessary permissions for camera access in your AndroidManifest.xml:

```XML
<uses-permission android:name="android.permission.CAMERA" />
<uses-feature android:name="android.hardware.camera.any" />
```
5. Display the Preview, make sure you have a PreviewView in your layout (activity_main.xml):

```XML
<androidx.camera.view.PreviewView
    android:id="@+id/previewView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

6. Run Your App, build and run your app. You’ll see the camera preview in the PreviewView. When you capture a photo, it will be saved to the specified file location.


**Happy Coding**


