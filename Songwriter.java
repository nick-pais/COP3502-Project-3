/*Nickolas Pais
 * COP3502 
 * April 4,2016
 * Program generates random frequencies, finds the Mid range frequency,
 * simulates the chords playing using periods as beats, and
 * finally sends notes to StdAudio to output to speakers.
 * Cool alien sounding pitches come from speakers!
 */

/*User Input
 * Takes in number of strings, chords, and the mid-range frequency.
 * Also Prints outputs
 */


package project3;
import java.util.Scanner;
public class Songwriter {
	public static void main(String[] args) throws InterruptedException{
		//USER INPUT
		Scanner in = new Scanner(System.in);
		System.out.println("Number of strings? ");
		int numStrings = in.nextInt();
		System.out.println("Number of chords? ");
		int numChords = in.nextInt();
		System.out.println("Mid-range frequency? ");
		double midRangeFreq = in.nextDouble();
		Guitar guitar = new Guitar(numChords, numStrings, midRangeFreq);
		System.out.println("Guitar(): Generated new guitar with " + numStrings + " strings. Song length is " + numChords + " chords.");
		guitar.generateSong();
		System.out.println("\nsimulateSong():");
		guitar.simulateSong();
		Vocalist vocals = new Vocalist(midRangeFreq, numChords, numStrings);
		System.out.print("\n");
		System.out.println("Vocalist(): midRangeFreq: " + midRangeFreq);
		System.out.println(vocals.toString());
		vocals.sing();
		in.close();
	}
}
