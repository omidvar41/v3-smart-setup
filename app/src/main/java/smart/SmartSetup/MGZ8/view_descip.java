package smart.SmartSetup.MGZ8;

import android.view.View;

/**
 * Created by GENERAL on 6/30/2018.
 */

public class view_descip {
    View  view;
  String  title;
    String desc;

    public view_descip(View view, String title, String desc) {
        this.view = view;
        this.title = title;
        this.desc = desc;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
