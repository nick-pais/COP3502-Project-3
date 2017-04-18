/*Nickolas Pais
 * COP3502 
 * April 4,2016
 * Program generates random frequencies, finds the Mid range frequency,
 * simulates the chords playing using periods as beats, and
 * finally sends notes to StdAudio to output to speakers.
 * Cool alien sounding pitches come from speakers!
 */

//Constructor for creating guitar frequency array

package project3;
public class Guitar {
	//Data Field
	private static int numChords;
	private static int numStrings;
	private static double[][] songArray;
	
	//Constructor
	Guitar(int numChords, int numStrings, double midRangeFreq){
		Guitar.numChords = numChords;
		Guitar.numStrings = numStrings;
		songArray = new double [numStrings + 1][numChords];
	}
	public void generateSong(){
		/**Generates array based off number of Strings and Chords with number of beats for each chord */
		for (int row = 0; row < numStrings +1; row++ ){
			for (int column =0; column <numChords; column++){
				if (row == numStrings){
					//Generates random beats between 1 and 3 then prints only if its the bottom row
					songArray[row][column] = ((Math.random()*2));
					System.out.printf("%7.1f ", songArray[row][column]);
					}
				else{
				//Generates guitar frequency
				//PRINTS IT
				songArray[row][column] = (27.5+(Math.random()*4186));
				System.out.printf("%7.2f ", songArray[row][column]);
				}
				if (column == numChords -1){
					System.out.print("\n");
				}
			}
		}
		
	}
	public void simulateSong() throws InterruptedException{
		/** Simulates the playing of the song */
		int beats;
		for (int column =0; column < numChords; column++ ){
			for (int row =0; row < numStrings; row++){
				//Prints the first column of frequencies all at once.
				System.out.printf("%7.2f ", songArray[row][column]);
				if (row == numStrings-1){
					beats = (int)Math.ceil(songArray[row+1][column]);
					for (int i = 0; i < beats; i++){
						Thread.sleep(1000);
						System.out.print(".");
					}
					System.out.print("\n");
				}
			}
		}
		
	}
	public static double[] getChordsArray(int chordNumber){
		/** Return a double 1 dimensional array for the chord selected */
		if (chordNumber > numChords){
			System.out.print("No such chord!");
			return null;
		}
		double []array = new double[numStrings+1];
		for (int row =0; row < numStrings+1; row++ ){
			array[row] = songArray[row][chordNumber];
		}
		return array;
		
	}
}
	

