package inspire.example.com.demo1;

/**
 * Created by Himanshu25 on 7/17/2016.
 */import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.os.Bundle;
import android.widget.VideoView;


public class FragmentVirtual extends Fragment {
    VideoView videoView;
    Uri uri;
    MediaController media;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video, container, false);


        media=new MediaController(getActivity());
        videoView=(VideoView)v.findViewById(R.id.videoView);
        uri= Uri.parse("android.resource://" + "inspire.example.com.demo1" + "/" + R.raw.virtual5);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        videoView.setMediaController(media);
        return v;

    }
}

