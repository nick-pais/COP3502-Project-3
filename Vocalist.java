/*Nickolas Pais
 * COP3502 
 * April 4,2016
 * Program generates random frequencies, finds the Mid range frequency,
 * simulates the chords playing using periods as beats, and
 * finally sends notes to StdAudio to output to speakers.
 * Cool alien sounding pitches come from speakers!
 */

package project3;

public class Vocalist {
	//Data Field
	private double midRangeFreq;
	private double[] guitarChord;
	private int numChords;
	private int numStrings;
	private double[][] freqAndBeats;
	
	//Constructor
	Vocalist (double midRangeFreq, int numChords, int numStrings){
		this.midRangeFreq = midRangeFreq;
		this.numChords = numChords;
		this.numStrings = numStrings;
		freqAndBeats = new double [numChords][2];
	}
	public String toString(){
		//FINDS MID-RANGE FREQUENCY FOR EACH STRING AND THE BEAT NUMBER AND RETURNS A STRING 
		String MRF ="";
		double difference;
		int idx = 0;
		double beats = 0;
		for (int i=0; i < numChords; i++){
			double smallestDifference = 10000;
			guitarChord = Guitar.getChordsArray(i);
			for (int j =0; j < guitarChord.length-1; j++){
				//FINDS THE NUMBER CLOSEST TO MID-RANGE FREQUENCY
				difference = Math.abs(guitarChord[j] - midRangeFreq);
				if (difference < smallestDifference){
					idx = j;
					smallestDifference = difference;
				}
			}
			//ADDS MID-RANGE FREQUENCY FOR EACH CHORD INTO THE FIRST ARRAY
			freqAndBeats[i][0] = guitarChord[idx];
			//CONCATENATES MID-RANGE FREQUENCY FOR EACH CHORD TO STRING
			MRF += String.format("%7.2f", guitarChord[idx]) + " ";
		}
		MRF += "\n";
		for (int i =0; i < numChords; i++){
			//OBTAINS THE BEAT FOR EACH CHORD
			guitarChord = Guitar.getChordsArray(i);
			beats = guitarChord[numStrings];
			//ADDS BEAT TO THE SECOND ROW IN ARRAY
			freqAndBeats[i][1] = beats;
			//CONCATENATES THE BEATS TO THE MID-RANGE FREQUENCY STRING
			MRF += String.format("%7.1f ", beats);
		}
		
		return MRF;
	}
	public void sing(){
		/** RETURNS THE VOCAL SOUND */
		for (int i =0; i < numChords; i++){
			StdAudio.playTone(freqAndBeats[i][0], freqAndBeats[i][1]);
		}
		
	}

}
