package com.rodrigosambade.quicksettings;

import android.app.*; import android.app.StatusBarManager; import android.os.*; import android.content.*; import android.graphics.drawable.Icon; import android.service.quicksettings.TileService; import android.view.*; import android.widget.*; import java.util.concurrent.Executors;

public class MainActivity extends Activity {
  private TextView status;
  @Override public void onCreate(Bundle b) { super.onCreate(b); buildUi(); refresh(); }
  private void buildUi() { LinearLayout l=new LinearLayout(this); l.setOrientation(LinearLayout.VERTICAL); l.setPadding(40,40,40,40);
    TextView h=new TextView(this); h.setText("Quick Settings Tile lab"); h.setTextSize(24); l.addView(h);
    status=new TextView(this); l.addView(status);
    Button add=new Button(this); add.setText("Request tile addition"); add.setOnClickListener(v->requestTile()); l.addView(add);
    Button toggle=new Button(this); toggle.setText("Toggle shared state"); toggle.setOnClickListener(v->{ boolean n=!getPreferences(); getSharedPreferences("tile",MODE_PRIVATE).edit().putBoolean("enabled",n).apply(); TileService.requestListeningState(this,new ComponentName(this,DemoTileService.class)); refresh(); }); l.addView(toggle); setContentView(l); }
  private boolean getPreferences() { return getSharedPreferences("tile",MODE_PRIVATE).getBoolean("enabled",false); }
  private void refresh() { if(status!=null) status.setText("Stored state: "+(getPreferences()?"ACTIVE":"INACTIVE")); }
  private void requestTile() {
    if (Build.VERSION.SDK_INT >= 33) {
      StatusBarManager manager = getSystemService(StatusBarManager.class);
      if (manager == null) { Toast.makeText(this, "StatusBarManager unavailable", Toast.LENGTH_LONG).show(); return; }
      manager.requestAddTileService(new ComponentName(this, DemoTileService.class), "Demo tile", Icon.createWithResource(this, android.R.drawable.ic_menu_manage), Executors.newSingleThreadExecutor(), r -> runOnUiThread(() -> Toast.makeText(this, "Result: " + r, Toast.LENGTH_SHORT).show()));
    } else {
      Toast.makeText(this, "Open Quick Settings edit mode and add Demo tile", Toast.LENGTH_LONG).show();
    }
  }
}
