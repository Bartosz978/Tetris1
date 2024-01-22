package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Mapa {
    private Pixmap scianaPixmap = new Pixmap(Gdx.files.internal("0.bmp"));
    private Pixmap blokPixmap = new Pixmap(Gdx.files.internal("bas.jpeg"));
    ;
    public static int szerokosc;
    public static int wysokosc;
    public int[][] Plansza_do_gry;
    public int x;
    public int y;

    public Mapa() {
        this.x = (szerokosc / 50);
        this.y = (wysokosc / 50);
        Plansza_do_gry = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                Plansza_do_gry[i][j] = 0;
            }
        }
        //  Plansza_do_gry[0][0]=1;


        //Kolizje
        for (int i = 0; i < y; i++) {
            Plansza_do_gry[i][0] = 9;
        }
        for (int i = 0; i < y; i++) {
            Plansza_do_gry[i][x - 1] = 9;
        }
        for (int i = 0; i < x; i++) {
            Plansza_do_gry[y - 1][i] = 9;
        }
        test();
        zapiszDoPliku("text.txt", Plansza_do_gry);
    }

    void test() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++)
                System.out.print(Plansza_do_gry[i][j]);
            System.out.println();
        }
    }

    boolean Kolizja(Obiekty obiekty, boolean poziomo, int odcinek) {
        int PomocniczeY = 0;
        for (int i = 0; i < obiekty.blok.size(); i++) {
            //System.out.println(obiekty.blok.get(i).x );
            PomocniczeY = 800 - (obiekty.blok.get(i).y);

            //System.out.println(i);
            //System.out.println(Plansza_do_gry[( / 50)][(obiekty.blok.get(i).y / 50)]);
            if (obiekty.blok.get(i).y < 801) {
                //System.out.println(obiekty.blok.get(i).x);
                if (poziomo) {
                    if (Plansza_do_gry[PomocniczeY / 50][((obiekty.blok.get(i).x + odcinek) / 50)] != 0) {
                        return false;
                    }

                } else {

                    if (Plansza_do_gry[(PomocniczeY) / 50][(obiekty.blok.get(i).x / 50)] != 0) {
                        obiekty.Zapisz_do_tablicy_polozenie(Plansza_do_gry);
                        MyGdxGame.Zapis = true;

                        Sprawdz_Czy_Jest_blok(1);
                        // MyGdxGame.posiada_klocek = false;


                        return false;
                    }
                }
            }


        }
        return true;
    }

    public static void zapiszDoPliku(String nazwaPliku, int[][] tablica) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku))) {
            for (int[] wiersz : tablica) {
                for (int element : wiersz) {
                    writer.write(Integer.toString(element));
                    writer.write(" ");
                }
                writer.newLine();
            }
            System.out.println("Tablica została zapisana do pliku: " + nazwaPliku);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisywania do pliku: " + e.getMessage());
        }
    }

    void Rysuj_od_nowa() {
        Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);

        int color = Color.rgba8888(0, 0.39f, 0, 1);
        pixmap.setColor(color);

        pixmap.fill();
        for (int i = y - 1; i > -1; i--) {
            for (int j = 0; j < x; j++) {
                if (Plansza_do_gry[i][j] == 9) {
                    pixmap.drawPixmap(scianaPixmap, j * 50, i * 50);
                } else if (Plansza_do_gry[i][j] == 7) {
                    pixmap.drawPixmap(blokPixmap, j * 50, i * 50);
                }
            }
        }

        try {
            FileHandle fileHandle = Gdx.files.absolute("C:\\Users\\User\\Desktop\\Tetris\\assets\\tmp2.png");
            PixmapIO.writePNG(fileHandle, pixmap);
            System.out.println("Plansza została zapisana do pliku PNG: tmp2.png");
        } catch (Exception e) {
            System.err.println("Błąd podczas zapisywania do pliku PNG: " + e.getMessage());
        }
        pixmap.dispose();
        MyGdxGame.posiada_klocek = false;
        MyGdxGame.tmp = new Texture("C:\\Users\\User\\Desktop\\Tetris\\assets\\tmp2.png");
        MyGdxGame.Zapis = false;

    }


    void Sprawdz_Czy_Jest_blok(int repeat) {
        ArrayList<Integer> listaa = new ArrayList<>();
        System.out.println("Tak wykonuje sie");
        // Sprawdź, czy w którymkolwiek rzędzie jest pełny rząd bloków
        for (int i = y - 2; i > -1; i--) {
            int tmp = Plansza_do_gry[i][1];
            int a = 0;
            System.out.println(tmp);
            for (int j = 1; j < x - 1; j++) {
                if (tmp == 0) break;
                if (Plansza_do_gry[i][j] == tmp) a++;
                if (a == 14) {
                    listaa.add(i);
                    System.out.println("Zrbilem to tak zrobilem to");
                    break; // Dodaj tylko jeden raz, jeśli pełny rząd

                }
            }
        }
        if (listaa.size() > 0) {
            // Zamień pełne rzędy na zera
            for (int i = 0; i < listaa.size(); i++) {
                int row = listaa.get(i);
                for (int k = 1; k < x - 1; k++) {
                    Plansza_do_gry[row][k] = 0;

                }
            }
            int size = listaa.size();
            System.out.println(size);
            for (int i = 1; i < 15; i++) {
                for (int j = listaa.get(0); j > 0; j--) {
                    System.out.println("Dzialam");
                    if (j - size - 1 >= Plansza_do_gry.length) {
                        // Sprawdzamy, czy indeks nie wykracza poza zakres tablicy Plansza_do_gry
                        break;
                    }
                    if (Plansza_do_gry[j - size ][i] == 0) {
                        break;
                    }
                    Plansza_do_gry[j][i] = 7;
                    Plansza_do_gry[j - size  ][i] = 0;

                }
            }

          /*  for (int i = 0; i < listaa.size(); i++) {
                int row = listaa.get(i);
                for (int j = row; j > 0; j--) {
                    for (int k = 1; k < x - 1; k++) {
                        Plansza_do_gry[j][k] = Plansza_do_gry[j - listaa.size()][k];
                    }
                }*/
                test();
                zapiszDoPliku("text.txt", Plansza_do_gry);
                Rysuj_od_nowa();

                // Przesuń bloki w kolumnach powyżej o jedną pozycję w dół
 /*
    }*/
            }
            // Wywołaj funkcję rekurencyjnie, jeśli repeat > 0
            // if (repeat > 0) {
            // Sprawdz_Czy_Jest_blok(repeat - 1);
            //}
        }


    }
