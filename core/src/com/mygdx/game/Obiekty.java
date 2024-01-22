package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;


public class Obiekty {
    public int x;
    public int y;
    private Texture tekstura;
    public ArrayList<Punkt> blok;
    public int szerokosc;
    public int wysokosc;
    public int X_Region;
    public int Y_Region;
    private int ktory_klocek;
    public int ktory_obrot;
    public int max_y;

    public Texture getTekstura() {
        return tekstura;
    }

    Obiekty() {
        this.x = 300;
        this.y = Gdx.graphics.getHeight();
        blok = new ArrayList<>();

    }

    void Losowanie() {


        Random random = new Random();
        int a = random.nextInt(5) + 1;
       //int a = 5;
        ktory_klocek = a;

        String scieszka = Integer.toHexString(a) + ".bmp";

        this.tekstura = new Texture(scieszka);

        switch (a) {
            case 1:
                szerokosc = 100;
                wysokosc = 100;
                /*
                Punkt punkt = new Punkt((int) this.x, (int) this.y);
                Punkt punkt1 = new Punkt((int) this.x + szerokosc, (int) this.y);
                Punkt punkt2 = new Punkt((int) this.x + szerokosc, (int) this.y + wysokosc);
                Punkt punkt3 = new Punkt((int) this.x, (int) this.y + wysokosc);

*/
                Punkt punkt = new Punkt(this.x,this.y);
                Punkt punkt1 = new Punkt(this.x+50,this.y);
                Punkt punkt2 = new Punkt(this.x+50,this.y+50);
                Punkt punkt3 = new Punkt(this.x,this.y+50);
                blok.add(punkt);
                blok.add(punkt1);
                blok.add(punkt2);
                blok.add(punkt3);
                break;
            case 2:

                szerokosc = 50;
                wysokosc = 200;
                /*
                Punkt punkta = new Punkt((int) this.x, (int) this.y);
                Punkt punkt1a = new Punkt((int) this.x + szerokosc, (int) this.y);
                Punkt punkt2a = new Punkt((int) this.x + szerokosc, (int) this.y + wysokosc);
                Punkt punkt3a = new Punkt((int) this.x, (int) this.y + wysokosc);
                blok.add(punkta);
                blok.add(punkt1a);
                blok.add(punkt2a);
                blok.add(punkt3a);

                 */
                Punkt punktf = new Punkt(this.x,this.y);
                Punkt punkt1f = new Punkt(this.x,this.y+50);
                Punkt punkt2f = new Punkt(this.x,this.y+100);
                Punkt punkt3f = new Punkt(this.x,this.y+150);
                blok.add(punktf);
                blok.add(punkt1f);
                blok.add(punkt2f);
                blok.add(punkt3f);
                break;
            case 3:


                szerokosc = 100;
                wysokosc = 150;
/*
                Punkt punktb = new Punkt(this.x, this.y);
                Punkt punktb0 = new Punkt(50 + this.x, this.y);
                Punkt punktb1 = new Punkt(this.x + 50, this.y + 50);
                Punkt punktb2 = new Punkt(this.x + 100, this.y + 50);
                Punkt punktb3 = new Punkt(this.x + 100, this.y + 100);
                Punkt punktb4 = new Punkt(this.x + 50, this.y + 100);
                Punkt punktb5 = new Punkt(this.x + 50, this.y + 150);
                Punkt punktb6 = new Punkt(this.x, this.y + 150);


                blok.add(punktb);
                blok.add(punktb0);
                blok.add(punktb1);
                blok.add(punktb2);
                blok.add(punktb3);
                blok.add(punktb4);
                blok.add(punktb5);
                blok.add(punktb6);
*/
                Punkt punkte = new Punkt(this.x,this.y);
                Punkt punkt1e = new Punkt(this.x,this.y+50);
                Punkt punkt2e = new Punkt(this.x+50,this.y+50);
                Punkt punkt3e = new Punkt(this.x,this.y+100);
                blok.add(punkte);
                blok.add(punkt1e);
                blok.add(punkt2e);
                blok.add(punkt3e);
                break;
            case 4:
                szerokosc = 150;
                wysokosc = 100;
/*
                Punkt punktc = new Punkt(this.x, this.y);
                Punkt punktc1 = new Punkt(this.x + 100, this.y);
                Punkt punktc2 = new Punkt(this.x + 100, this.y + 50);
                Punkt punktc3 = new Punkt(this.x + 150, this.y + 50);
                Punkt punktc4 = new Punkt(this.x + 150, this.y + 100);
                Punkt punktc5 = new Punkt(this.x + 50, this.y + 100);
                Punkt punktc6 = new Punkt(this.x + 50, this.y + 50);
                Punkt punktc7 = new Punkt(this.x, this.y + 50);

                blok.add(punktc);
                blok.add(punktc1);
                blok.add(punktc2);
                blok.add(punktc3);
                blok.add(punktc4);
                blok.add(punktc5);
                blok.add(punktc6);
                blok.add(punktc7);
*/
                Punkt punktb = new Punkt(this.x,this.y);
                Punkt punkt1b = new Punkt(this.x+50,this.y);
                Punkt punkt2b = new Punkt(this.x+50,this.y+50);
                Punkt punkt3b = new Punkt(this.x+100,this.y+50);
                blok.add(punktb);
                blok.add(punkt1b);
                blok.add(punkt2b);
                blok.add(punkt3b);
                break;
            case 43:
                szerokosc = 150;
                wysokosc = 100;
/*
                Punkt punktd = new Punkt(50 + this.x, this.y);
                Punkt punktd1 = new Punkt(this.x + 150, this.y);
                Punkt punktd2 = new Punkt(this.x + 150, this.y + 50);
               Punkt punktd3 = new Punkt(this.x + 100, this.y + 50);
                Punkt punktd4 = new Punkt(this.x + 100, this.y + 100);
              Punkt punktd5 = new Punkt(this.x, this.y + 100);
               Punkt punktd6 = new Punkt(this.x, this.y + 50);
                Punkt punktd7 = new Punkt(this.x + 50, this.y + 50);

                blok.add(punktd);
                blok.add(punktd1);
                blok.add(punktd2);
                blok.add(punktd3);
                blok.add(punktd4);
                blok.add(punktd5);
                blok.add(punktd6);
                blok.add(punktd7);
*/
                Punkt punkta = new Punkt(this.x+50,this.y);
                Punkt punkt1a = new Punkt(this.x+100,this.y);
                Punkt punkt2a = new Punkt(this.x,this.y+50);
                Punkt punkt3a = new Punkt(this.x,this.y+50);
                blok.add(punkta);
                blok.add(punkt1a);
                blok.add(punkt2a);
                blok.add(punkt3a);
                break;
            case 5:
                szerokosc = 150;
                wysokosc = 100;
/*
                Punkt punkte = new Punkt(this.x, this.y);
                Punkt punkte1 = new Punkt(this.x + 150, this.y);
                Punkt punkte2 = new Punkt(this.x + 150, this.y + 50);
                Punkt punkte3 = new Punkt(this.x + 50, this.y + 50);
                Punkt punkte4 = new Punkt(this.x + 50, this.y + 100);
                Punkt punkte5 = new Punkt(this.x, this.y + 100);

                blok.add(punkte);
                blok.add(punkte1);
                blok.add(punkte2);
                blok.add(punkte3);
                blok.add(punkte4);
                blok.add(punkte5);

 */
                Punkt punktc = new Punkt(this.x,this.y);
                Punkt punkt1c = new Punkt(this.x,this.y+50);
                Punkt punkt2c = new Punkt(this.x+50,this.y);
                Punkt punkt3c = new Punkt(this.x+100,this.y);
                blok.add(punktc);
                blok.add(punkt1c);
                blok.add(punkt2c);
                blok.add(punkt3c);
                break;


        }
        X_Region = 0;
        Y_Region = 0;
        ktory_obrot = 0;
    }

    void Tranformacja() {


        switch (ktory_klocek) {
            case 2:
                if (wysokosc > szerokosc) {
                    Y_Region = wysokosc;
                } else {
                    Y_Region = 0;
                }

                int tmp = szerokosc;
                szerokosc = wysokosc;
                wysokosc = tmp;
                break;
            case 3:
                ktory_obrot++;

                if (ktory_obrot == 4) {
                    ktory_obrot = 0;
                }

                int tmp2 = szerokosc;
                szerokosc = wysokosc;
                wysokosc = tmp2;
                if (ktory_obrot == 1 || ktory_obrot == 3) {
                    Y_Region = ktory_obrot * 150;
                    if (ktory_obrot == 3) Y_Region -= 50;
                } else if (ktory_obrot == 2) {
                    Y_Region = ktory_obrot * 150 - 50;
                } else {
                    Y_Region = 0;
                }
                break;
            case 4:
                if (wysokosc < szerokosc) {
                    Y_Region = wysokosc;
                } else {
                    Y_Region = 0;
                }
                int tmp3 = szerokosc;
                szerokosc = wysokosc;
                wysokosc = tmp3;
                break;
            case 5:
                wysokosc = 100;
                szerokosc =150;
                X_Region =0;
                Y_Region = 150;
                /*
                if (wysokosc < szerokosc) {
                    Y_Region = wysokosc;
                    X_Region = 50;

                } else {
                    Y_Region = 0;
                    X_Region = 0;
                }
                int tmp4 = szerokosc;
                szerokosc = wysokosc;
                wysokosc = tmp4;
                /*
                Y_Region = 0;
                X_Region = 150;

                 */
                break;
            case 6:

                break;
        }
    }

    public void Poruszanie(int odcinek,boolean Poziomo){
       // System.out.println("h");
        if (this.x != 0 && this.y != 0) {
            for (int i = 0; i < blok.size(); i++) {
                if(Poziomo){
                    blok.get(i).x = blok.get(i).x  + odcinek;
                }else {
                    blok.get(i).y = blok.get(i).y  + odcinek;

                }

             }
        }
    }
    void Zapisz_do_tablicy_polozenie(int tab[][]){
        int pomocnyY= 0;
        for(int i=0;i<blok.size();i++){
            pomocnyY = 800 -  ((blok.get(i).y)+50);
            System.out.println(pomocnyY/50);
            tab[(pomocnyY/50)][blok.get(i).x/50] = 7;
        }
        MyGdxGame.Zapis=true;
    }

}
