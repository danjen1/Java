package Chapter11;
import javax.sound.midi.*;

public class MiniMiniMusicApp
{
    public static void main(String[] args)
    {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play()
    {
        try
        {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 109, 100);
           // a.setMessage(192, 1, 102, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(144, 1, 109, 100);
            MidiEvent noteOff = new MidiEvent(b, 36);
            track.add(noteOff);
            player.setSequence(seq);
            player.start();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
