# Android Quick Settings Tile Lab

Reimplementation-oriented Android lab demonstrating a custom `TileService`, persistent tile state, `requestAddTileService()` on modern Android, and the Quick Settings tile lifecycle.

## Try it
Run on Android 7.0+; on Android 13+ the app can request that the system add the tile. The tile itself toggles a shared preference and updates its active/inactive state.

Built with Java 17, target SDK 37, and API 37.1 CI.
