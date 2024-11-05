import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        System.out.println(challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        System.out.println(challengeTwoAnswer);
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        System.out.println(challengeThreeAnswer);
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");
        System.out.println(challengeFourAnswer);
        /**writeFileAllAnswers(challengeOneAnswer;);
         ***/
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int linesInFile = countLinesInFile(fileName);
        int[] depths = new int[linesInFile];

        int index = 0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            depths[index++] = scanner.nextInt();
        }

        int increaseCount = 0;

        for (int i = 1;i<depths.length;i++){
            if (depths[i]>depths[i-1]){
                increaseCount++;
            }
        }

        return increaseCount;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int linesInFile = countLinesInFile(fileName);
        int[] depths = new int[linesInFile];

        int index = 0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            depths[index++] = scanner.nextInt();
        }

        int increaseCount = 0;

        for (int i = 0;i<depths.length-3;i++){
            int nowThreeSum = depths[i]+depths[i+1]+depths[i+2];
            int nextThreeSum = depths[i+1]+depths[i+2]+depths[i+3];
            if (nowThreeSum<nextThreeSum){
                increaseCount++;
            }
        }
        return increaseCount;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int linesInFile = countLinesInFile(fileName);
        String[] movements = new String[linesInFile];

        int index = 0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            movements[index++] = scanner.nextLine();
        }

        int finalDepth = 0;
        int finalDistance = 0;
        for (int i=0;i<movements.length;i++){
            String current = movements[i];
            String[] currentSplit = current.split(" ");
            int byAmount = Integer.parseInt(currentSplit[1]);
            if(currentSplit[0].equals("forward")){
                finalDistance = finalDistance + byAmount;
            }
            else if(currentSplit[0].equals("down")){
                finalDepth = finalDepth + byAmount;
            }
            else{
                finalDepth = finalDepth - byAmount;
            }
        }
        return finalDistance * finalDepth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int linesInFile = countLinesInFile(filename);
        String[] movements = new String[linesInFile];

        int index = 0;
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            movements[index++] = scanner.nextLine();
        }

        int finalDepth = 0;
        int finalDistance = 0;
        int aim = 0;
        for (int i=0;i<movements.length;i++){
            String current = movements[i];
            String[] currentSplit = current.split(" ");
            int byAmount = Integer.parseInt(currentSplit[1]);
            if(currentSplit[0].equals("forward")){
                finalDistance += byAmount;
                finalDepth += aim * byAmount;
            }
            else if(currentSplit[0].equals("down")){
                aim += byAmount;
            }
            else{
                aim -= byAmount;
            }
        }
        return finalDistance * finalDepth;
    }
    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}