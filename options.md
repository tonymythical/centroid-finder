      <Matthew's Finds>
-------     -------    -------
# Java Video Processing Library Options

## 1. JCodec
**Description:** A pure Java implementation for decoding and encoding MP4 and MOV video formats without requiring external native binaries.
* Pros:
  * No Native Dependencies: 100% pure Java, meaning it runs smoothly anywhere without installing FFmpeg or C++ binaries on the host system.
  * Frame-by-Frame Control: Allows easy extraction of frames at specific numbers or timestamps (`FrameGrab.getFrameFromFile`).
  * Easy Conversion: Provides utility methods (`AWTUtil.toBufferedImage`) to turn decoded video frames directly into standard Java `BufferedImage` objects for image processing.
* Cons:
  * Limited Format Support: Focused heavily on MP4/MOV; less versatile for obscure video codecs.
  * Performance: Can be slower than native wrapper libraries when dealing with high-resolution or very long videos.

*Example Code Snippet:*
```java
int frameNumber = 42;
Picture picture = FrameGrab.getFrameFromFile(new File("video.mp4"), frameNumber);
BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
ImageIO.write(bufferedImage, "png", new File("frame42.png"));