import edu.princeton.cs.introcs.StdAudio;
import synthesizer.GuitarString;
public class GuitarHero {
    public static void main(String[] args){
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        int keyNum = 37;
        GuitarString[] keys = new GuitarString[37];
        for(int i = 0; i < keyNum; i++){
            double frequency = 440 * Math.pow(2, (i - 24) / 12);
            keys[i] = new GuitarString(frequency);
        }

        while(true){
            if(StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                try {
                    int index = keyboard.indexOf(key);
                    keys[index].pluck();
                } catch (Exception e) {
                    System.out.println("can not recognize the key: " + key);
                }
            }

            double sample = 0.0;
            for(int i = 0; i < keyNum; i++){
                sample += keys[i].sample();
            }

            StdAudio.play(sample);

            for(int i = 0; i < keyNum; i++){
                keys[i].tic();
            }
        }
    }
}
