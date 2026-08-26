package com.rodrigosambade.quicksettings;
import android.service.quicksettings.*;
public class DemoTileService extends TileService {
  private boolean enabled() { return getSharedPreferences("tile",MODE_PRIVATE).getBoolean("enabled",false); }
  private void render() { Tile t=getQsTile(); if(t==null)return; t.setState(enabled()?Tile.STATE_ACTIVE:Tile.STATE_INACTIVE); t.setLabel(enabled()?"Demo: on":"Demo: off"); t.updateTile(); }
  @Override public void onStartListening() { super.onStartListening(); render(); }
  @Override public void onClick() { super.onClick(); getSharedPreferences("tile",MODE_PRIVATE).edit().putBoolean("enabled",!enabled()).apply(); render(); }
}
