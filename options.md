      <Matthew's Finds>
-------     -------    -------

1) jcodec (Repo: https://github.com/jcodec/jcodec)

JCodec seems useful for our purposes here, with this package's example code, we could hypothetically go frame by frame and process each frame of the video as a file independently. Maybe to save on performance we could increase the buffer between processing frames or resolution of the video? With this we could do both of these optimizations.

``int frameNumber = 42;
Picture picture = FrameGrab.getFrameFromFile(new File("video.mp4"), frameNumber);

//for JDK (jcodec-javase)
BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
ImageIO.write(bufferedImage, "png", new File("frame42.png"));

//for Android (jcodec-android)
Bitmap bitmap = AndroidUtil.toBitmap(picture);
bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream("frame42.png"));``

2) bytedeco, javacv (Documentation: https://bytedeco.org/javacv/apidocs/org/bytedeco/javacv/FFmpegFrameGrabber.html)

A specific function, but javacv works for this!

They have a frame grabber for use here, much like jcodec