package tiles;

import javax.imageio.ImageIO;
import java.util.Objects;

public class TileList {

    public Tile[] tileID = new Tile[3920];   // #tiles+2 (empty)

    public TileList() {
        try {
            // create all tiles
            for (int i = 0; i < tileID.length; i++) tileID[i] = new Tile();

            // assign an image to each tile
            tileID[0].image = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Blank.png")));
            for (int ID = 1; ID < tileID.length / 2; ID++)
                tileID[ID].image = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Tile ID = (" + ID + ").png")));

            // set collision tiles
            for (int i = tileID.length / 2; i < tileID.length; i++) {
                tileID[i].image = tileID[i - tileID.length / 2].image;
                tileID[i].collision = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assignTileTypes();
    }

    void assignTileTypes() {

        // this is gonna be messy...

        for (int i = 1; i < 9; i++) tileID[i].GRASS = true;
        for (int i = 9; i < 41; i++) tileID[i].TREES = true;
        for (int i = 41; i < 73; i++) tileID[i].GRASS_AESTHETICS = true;
        for (int i = 73; i < 82; i++) tileID[i].LEVELED_GRASS = true;
        for (int i = 82; i < 123; i += 40) tileID[i].STAIRS_LADDERS = true;
        for (int i = 83; i < 94; i++) tileID[i].LEVELED_GRASS = true;
        for (int i = 94; i < 103; i += 8) tileID[i].STAIRS_LADDERS = true;
        for (int i = 95; i < 102; i++) tileID[i].LEVELED_GRASS = true;
        for (int i = 103; i < 122; i++) tileID[i].LEVELED_GRASS = true;
        for (int i = 123; i < 134; i++) tileID[i].LEVELED_GRASS = true;
        for (int i = 134; i < 143; i += 8) tileID[i].STAIRS_LADDERS = true;
        for (int i = 135; i < 152; i += 8) tileID[i].STAIRS_LADDERS = true;
        for (int i = 136; i < 153; i += 8) tileID[i].LEVELED_GRASS = true;
        for (int i = 137; i < 142; i++) tileID[i].LEVELED_GRASS = true;
        for (int i = 145; i < 151; i++) tileID[i].LEVELED_GRASS = true;
        for (int i = 153; i < 177; i++) tileID[i].FARMING_AESTHETICS = true;
        for (int i = 177; i < 225; i++) tileID[i].FENCES = true;
        for (int i = 225; i < 230; i++) tileID[i].MISCELLANEOUS = true;
        for (int i = 233; i < 235; i++) tileID[i].MISCELLANEOUS = true;
        for (int i = 230; i < 233; i++) tileID[i].SIGNS = true;
        for (int i = 235; i < 241; i++) tileID[i].SIGNS = true;
        for (int i = 241; i < 247; i++) tileID[i].WALLS = true;
        for (int i = 249; i < 254; i++) tileID[i].WALLS = true;
        for (int i = 257; i < 262; i++) tileID[i].WALLS = true;
        for (int i = 247; i < 249; i++) tileID[i].MISCELLANEOUS = true;
        for (int i = 254; i < 257; i++) tileID[i].MISCELLANEOUS = true;
        for (int i = 262; i < 289; i++) tileID[i].MISCELLANEOUS = true;
        for (int i = 289; i < 295; i++) tileID[i].FLOORS = true;
        for (int i = 297; i < 303; i++) tileID[i].FLOORS = true;
        for (int i = 305; i < 311; i++) tileID[i].FLOORS = true;
        for (int i = 313; i < 319; i++) tileID[i].FLOORS = true;
        for (int i = 321; i < 327; i++) tileID[i].FLOORS = true;
        for (int i = 330; i < 334; i += 3) tileID[i].FLOORS = true;
        for (int i = 295; i < 297; i++) tileID[i].STAIRS_LADDERS = true;
        for (int i = 303; i < 305; i++) tileID[i].STAIRS_LADDERS = true;
        for (int i = 311; i < 313; i++) tileID[i].STAIRS_LADDERS = true;
        for (int i = 319; i < 321; i++) tileID[i].STAIRS_LADDERS = true;
        for (int i = 327; i < 330; i++) tileID[i].STAIRS_LADDERS = true;
        for (int i = 331; i < 333; i++) tileID[i].STAIRS_LADDERS = true;
        for (int i = 334; i < 353; i++) tileID[i].STAIRS_LADDERS = true;
        for (int i = 360; i < 561; i += 8) tileID[i].DOORS = true;
        for (int i = 353; i < 360; i++) tileID[i].WALLS = true;
        for (int i = 361; i < 368; i++) tileID[i].WALLS = true;
        for (int i = 369; i < 376; i++) tileID[i].WALLS = true;
        for (int i = 377; i < 384; i++) tileID[i].WALLS = true;
        for (int i = 385; i < 392; i++) tileID[i].WALLS = true;
        for (int i = 393; i < 400; i++) tileID[i].WALLS = true;
        for (int i = 401; i < 408; i++) tileID[i].WALLS = true;
        for (int i = 409; i < 416; i++) tileID[i].WALLS = true;
        for (int i = 417; i < 424; i++) tileID[i].WALLS = true;
        for (int i = 425; i < 432; i++) tileID[i].WALLS = true;
        for (int i = 433; i < 440; i++) tileID[i].WALLS = true;
        for (int i = 441; i < 448; i++) tileID[i].WALLS = true;
        for (int i = 449; i < 456; i++) tileID[i].WALLS = true;
        for (int i = 457; i < 464; i++) tileID[i].WALLS = true;
        for (int i = 465; i < 472; i++) tileID[i].WALLS = true;
        for (int i = 473; i < 480; i++) tileID[i].WALLS = true;
        for (int i = 481; i < 488; i++) tileID[i].WALLS = true;
        for (int i = 489; i < 496; i++) tileID[i].WALLS = true;
        for (int i = 497; i < 504; i++) tileID[i].WALLS = true;
        for (int i = 505; i < 512; i++) tileID[i].WALLS = true;
        for (int i = 513; i < 520; i++) tileID[i].WALLS = true;
        for (int i = 521; i < 528; i++) tileID[i].WALLS = true;
        for (int i = 529; i < 536; i++) tileID[i].WALLS = true;
        for (int i = 537; i < 544; i++) tileID[i].WALLS = true;
        for (int i = 545; i < 552; i++) tileID[i].WALLS = true;
        for (int i = 553; i < 560; i++) tileID[i].WALLS = true;
        for (int i = 561; i < 593; i++) tileID[i].ROOFS = true;
        for (int i = 593; i < 641; i++) tileID[i].BUILDING_AESTHETICS = true;
        for (int i = 641; i < 657; i++) tileID[i].DOORS = true;
        for (int i = 657; i < 673; i++) tileID[i].SIGNS = true;
        for (int i = 673; i < 697; i++) tileID[i].WALLS = true;
        for (int i = 697; i < 699; i++) tileID[i].BUILDING_AESTHETICS = true;
        for (int i = 699; i < 705; i++) tileID[i].WALLS = true;
        for (int i = 705; i < 710; i++) tileID[i].BUILDING_AESTHETICS = true;
        for (int i = 710; i < 713; i++) tileID[i].WALLS = true;
        for (int i = 713; i < 857; i++) tileID[i].BUILDING_AESTHETICS = true;
        for (int i = 857; i < 905; i++) tileID[i].CONTAINERS = true;
        for (int i = 905; i < 953; i++) tileID[i].STATUES_STRUCTURES = true;
        for (int i = 912; i < 953; i += 8) tileID[i].STATUES_STRUCTURES = false;
        for (int i = 912; i < 953; i += 8) tileID[i].BUILDING_AESTHETICS = true;
        for (int i = 953; i < 1057; i++) tileID[i].MARKET_SUPPLIES = true;
        for (int i = 1057; i < 1104; i++) tileID[i].WATER = true;
        for (int i = 1104; i < 1245; i++) tileID[i].GRASS = true;
        for (int i = 1245; i < 1293; i++) tileID[i].SHADOWS = true;
        for (int i = 1293; i < 1387; i++) tileID[i].GRASS = true;
        for (int i = 1387; i < 1451; i++) tileID[i].DOORS = true;
        for (int i = 1451; i < 1498; i++) tileID[i].WATER = true;
        for (int i = 1498; i < 1501; i++) tileID[i].GRASS = true;
        for (int i = 1501; i < 1561; i++) tileID[i].TREES = true;
        for (int i = 1568; i < 1572; i++) tileID[i].TREES = true;
        for (int i = 1579; i < 1583; i++) tileID[i].TREES = true;
        for (int i = 1590; i < 1594; i++) tileID[i].TREES = true;
        for (int i = 1561; i < 1660; i++) tileID[i].LEVELED_GRASS = true;
        for (int i = 1568; i < 1572; i++) tileID[i].LEVELED_GRASS = false;
        for (int i = 1579; i < 1583; i++) tileID[i].LEVELED_GRASS = false;
        for (int i = 1590; i < 1594; i++) tileID[i].LEVELED_GRASS = false;
        for (int i = 1660; i < 1698; i++) tileID[i].GRASS_AESTHETICS = true;
        for (int i = 1698; i < 1710; i++) tileID[i].WALLS = true;
        for (int i = 1711; i < 1745; i++) tileID[i].WALLS = true;
        for (int i = 1745; i < 1859; i++) tileID[i].MISCELLANEOUS = true;
        for (int i = 1859; i < 1886; i++) tileID[i].CONTAINERS = true;
        for (int i = 1886; i < 1926; i++) tileID[i].SIGNS = true;
        for (int i = 1926; i < 1960; i++) tileID[i].STATUES_STRUCTURES = true;
    }
}