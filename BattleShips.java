import java.util.Scanner;

public class BattleShips {
        public static int Sumx = 8;
        public static int Sumy = 8;
        public static int AmerikaShips;
        public static int ChinaShips;
        public static String[][] grid = new String[Sumx][Sumy];
        public static int[][] missedGuesses = new int[Sumx][Sumy];

        public static void main(String[] args){
            System.out.println("SELAMAT DATANG DI GAME BATTLESHIPS AMERIKA VS CHINA");
            System.out.println("ARENA TELAH DI BUAT\n");


            createOceanMap();

            deployAmerikaShips();

            deployChinaShips();

            do {
                Battle();
            }while(BattleShips.AmerikaShips != 0 && BattleShips.ChinaShips != 0);

            gameOver();
        }

        public static void createOceanMap(){
            System.out.print("  ");
            for(int i = 1; i < Sumy; i++)
                System.out.print(i);
            System.out.println();

            for(int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[i].length; j++) {
                    grid[i][j] = " ";
                    if (j == 1)
                        System.out.print(i + "|" + grid[i][j]);
                    else if (j == grid[i].length - 1)
                        System.out.print(grid[i][j] + "|" + i);
                    else
                        System.out.print(grid[i][j]);
                }
                System.out.println();
            }

            System.out.print("  ");
            for(int i = 1; i < Sumy; i++)
                System.out.print(i);
            System.out.println();
        }

        public static void deployAmerikaShips(){
            Scanner input = new Scanner(System.in);

            System.out.println("\nAMERIKA SILAHKAN TURUNKAN KAPAL ANDA:");
            BattleShips.AmerikaShips = 5;
            for (int i = 1; i <= BattleShips.AmerikaShips; ) {
                System.out.print("MASUKKAN KOORDINAT X KAPAL" + i + ":");
                int x = input.nextInt();
                System.out.print("MASUKKAN KOORDINAT Y KAPAL" + i +":");
                int y = input.nextInt();

                if((x >= 0 && x < Sumx) && (y >= 0 && y < Sumy) && (grid[x][y] == " "))
                {
                    grid[x][y] =   "!";
                    i++;
                }
                else if((x >= 0 && x < Sumx) && (y >= 0 && y < Sumy) && grid[x][y] == "!")
                    System.out.println("ANDA TIDAK BISA MELETAKKAN KAPAL DI TEMPAT YANG SAMA");
                else if((x < 0 || x >= Sumx) || (y < 0 || y >= Sumy))
                    System.out.println("KAMU TIDAK BISA MELETAKKAN KAPAL DI LUAR AREA " + Sumx + " UNTUK " + Sumy + " AREA");
            }
            printOceanMap();
        }

    public static void deployChinaShips(){
        Scanner input = new Scanner(System.in);

        System.out.println("\nCHINA SILAHKAN TURUNKAN KAPAL ANDA:");
        BattleShips.ChinaShips = 5;
        for (int i = 1; i <= BattleShips.ChinaShips; ) {
            System.out.print("MASUKKAN KOORDINAT X KAPAL" + i + ":");
            int x = input.nextInt();
            System.out.print("MASUKKAN KOORDINAT Y KAPAL" + i +":");
            int y = input.nextInt();

            if((x >= 0 && x < Sumx) && (y >= 0 && y < Sumy) && (grid[x][y] == " "))
            {
                grid[x][y] =   "!";
                i++;
            }
            else if((x >= 0 && x < Sumx) && (y >= 0 && y < Sumy) && grid[x][y] == "!")
                System.out.println("ANDA TIDAK BISA MELETAKKAN KAPAL DI TEMPAT YANG SAMA");
            else if((x < 0 || x >= Sumx) || (y < 0 || y >= Sumy))
                System.out.println("KAMU TIDAK BISA MELETAKKAN KAPAL DI LUAR AREA " + Sumx + " UNTUK " + Sumy + " AREA");
        }
        printOceanMap();
    }

        public static void Battle(){
            AmerikaTurn();
            ChinaTurn();

            printOceanMap();

            System.out.println();
            System.out.println("KAPAL AMERIKA: " + BattleShips.AmerikaShips + " | KAPAL CHINA: " + BattleShips.ChinaShips);
            System.out.println();
        }

        public static void AmerikaTurn(){
            System.out.println("\nGILIRAN AMERIKA");
            int x = -1, y = -1;
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("MASUKKAN KOORDINAT X: ");
                x = input.nextInt();
                System.out.print("MASUKKAN KOORDINAT Y: ");
                y = input.nextInt();

                if ((x >= 0 && x < Sumx) && (y >= 0 && y < Sumy))
                {
                    if (grid[x][y] == "x")
                    {
                        System.out.println("DUARRRR KAMU MENGENAIK KAPAL MUSUH");
                        grid[x][y] = "!";
                        --BattleShips.ChinaShips;
                    }
                    else if (grid[x][y] == "@") {
                        System.out.println("TIDAKKKKK KAPAL MU HANCUR");
                        grid[x][y] = "X";
                        --BattleShips.AmerikaShips;
                        ++BattleShips.ChinaShips;
                    }
                    else if (grid[x][y] == " ") {
                        System.out.println("MAAF, ANDA TIDAK MENGENAI KAPAL MUSUH");
                        grid[x][y] = "-";
                    }
                }
                else if ((x < 0 || x >= Sumx) || (y < 0 || y >= Sumy))
                    System.out.println("KAMU TIDAK DAPAT MEMASUKKAN KAPAL DI LUAR AREA " + Sumx + " UNTUK " + Sumy + " AREA");
            }while((x < 0 || x >= Sumx) || (y < 0 || y >= Sumy));
        }

        public static void ChinaTurn(){
            System.out.println("\nGILIRAN CHINA");
            int x = -1, y = -1;
            do {
                x = (int)(Math.random() * 10);
                y = (int)(Math.random() * 10);

                if ((x >= 0 && x < Sumx) && (y >= 0 && y < Sumy))
                {
                    if (grid[x][y] == "@")
                    {
                        System.out.println("CHINA MENGHANCURKAN 1 AMERIKA");
                        grid[x][y] = "O";
                        --BattleShips.AmerikaShips;
                        ++BattleShips.ChinaShips;
                    }
                    else if (grid[x][y] == "x") {
                        System.out.println("CHINA MENEMBAK KAPALNYA SENDIRI");
                        grid[x][y] = "!";
                    }
                    else if (grid[x][y] == " ") {
                        System.out.println("CHINA TIDAK MENGENAI APAPUN");
                        if(missedGuesses[x][y] != 1)
                            missedGuesses[x][y] = 1;
                    }
                }
            }while((x < 0 || x >= Sumx) || (y < 0 || y >= Sumy));
        }

        public static void gameOver(){
            System.out.println("KAPAL AMERIKA: " + BattleShips.AmerikaShips + " | KAPAL CHINA: " + BattleShips.ChinaShips);
            if(BattleShips.AmerikaShips > 0 && BattleShips.ChinaShips <= 0)
                System.out.println("AMERIKA MEMENANGKAN PERTEMPURAN SELAMAT !!");
            else
                System.out.println("CHINA MEMENANGKAN PERTEMPURAN SELAMAT !!");
            System.out.println();
        }

        public static void printOceanMap(){
            System.out.println();
            System.out.print("  ");
            for(int i = 0; i < Sumy; i++)
                System.out.print(i);
            System.out.println();

            for(int x = 0; x < grid.length; x++) {
                System.out.print(x + "|");

                for (int y = 0; y < grid[x].length; y++){
                    System.out.print(grid[x][y]);
                }

                System.out.println("|" + x);
            }

            System.out.print("  ");
            for(int i = 0; i < Sumy; i++)
                System.out.print(i);
            System.out.println();
        }
    }

