# Enunciado didáctico reconstruido — Quick Settings Tile

Laboratorio Android para practicar la creación y el ciclo de vida de un **tile personalizado de Ajustes rápidos**.

La aplicación debe:

- declarar e implementar un `TileService`;
- mantener un estado activo/inactivo persistente;
- actualizar visualmente el tile al cambiar dicho estado;
- permitir que el usuario lo añada al panel de Ajustes rápidos;
- utilizar `requestAddTileService()` en versiones Android que soportan esa API;
- observar correctamente el ciclo de vida del servicio asociado al tile.

No existe una base de datos asociada; el estado sencillo del ejemplo se conserva mediante preferencias de la aplicación.
