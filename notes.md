eee

Read through ImageSummaryApp in detail with your partner. Understand what each part does. This will involve looking through and reading ALL of the other classes records and interfaces. This will take a long time, but it is worth it! Do not skimp on this part, you will regret it! Also look at the sampleInput and sampleOutput folders to understand what comes in and what goes out.

As you read through the files, take notes in notes.md to help you and your partner understand. Make frequent commits to your notes.

The ImageSummaryApp.java serves to summarize the functionality of our app into understandable pieces, to translate this into plain english I will detail my findings on interlocking functionality below

Conclusion: The ImageSummaryApp file utilizes three parameters to customize its targeting, saving its findings on the image as a file named groups.csv that contains coordinate values of outlined objects of a specific color.
``<input_image>`` ``<hex_target_color>`` ``<threshold>``

1: File checks for proper argument structure. (Threshold, Image, Color)
2: Two custom actors, the ColorDistanceFinder and DistanceImageBinarizer work to 
