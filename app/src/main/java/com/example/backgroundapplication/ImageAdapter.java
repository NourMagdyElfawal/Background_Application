package com.example.backgroundapplication;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImageAdapter extends PagerAdapter {
    Context context;
  public   ImageView imageView;
    private LayoutInflater inflater;


    public int[] GalImages = new int[] {


            R.drawable.birdd1,

            R.drawable.birdd2,

            R.drawable.birdd3,
            R.drawable.birdd4,

            R.drawable.birdd5,

            R.drawable.birdd6,
            R.drawable.birdd7,
            R.drawable.birdd8,

            R.drawable.birdd9,
            R.drawable.birdd10,
            R.drawable.birdd11,

            R.drawable.birdd12,
            R.drawable.birdd13,

            R.drawable.birdd14,

            R.drawable.birdd15,
            R.drawable.birdd16,

            R.drawable.birdd17,

            R.drawable.birdd18,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.birdd19,    //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.birdd20,

            R.drawable.birdd21,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.birdd22,    //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.birdd23,

            R.drawable.birdd24,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.birdd25,    //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.birdd26,

            R.drawable.birdd27,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.birdd28,    //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.birdd29,

            R.drawable.birdd30,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.birdd31,    //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.birdd32,

            R.drawable.birdd33,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.birdd34,    //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.birdd35,

            R.drawable.birdd36,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.birdd37,    //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.birdd38,

            R.drawable.birdd39,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.birdd40,    //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.birdd41,

            R.drawable.birdd42,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.birdd43,
            R.drawable.birdd44,
            R.drawable.birdd45,
            R.drawable.birdd46,
            R.drawable.birdd47,
            R.drawable.birdd48,
            R.drawable.birdd49,
            R.drawable.birdd50,
            R.drawable.birdd51,
            R.drawable.birdd52,
            R.drawable.birdd53,
            R.drawable.birdd54,
            R.drawable.birdd55,
            R.drawable.birdd56,
            R.drawable.birdd57,
            R.drawable.birdd58,
            R.drawable.birdd59,
            R.drawable.birdd60,
            R.drawable.birdd61,
            R.drawable.birdd62,
            R.drawable.birdd63,
            R.drawable.birdd64,
            R.drawable.birdd65,
            R.drawable.birdd66,
            R.drawable.birdd67,
            R.drawable.birdd68,
            R.drawable.birdd69,
            R.drawable.birdd70,
            R.drawable.birdd71,
            R.drawable.birdd72,
            R.drawable.birdd73,
            R.drawable.birdd74,
            R.drawable.birdd75,
            R.drawable.birdd76,
            R.drawable.birdd77,
            R.drawable.birdd78,
            R.drawable.birdd79,
            R.drawable.birdd80,
            R.drawable.birdd81,
            R.drawable.birdd82,
            R.drawable.birdd83,
            R.drawable.birdd84,
            R.drawable.birdd85,
            R.drawable.birdd86,
            R.drawable.birdd87,
            R.drawable.birdd88,
            R.drawable.birdd89,
            R.drawable.birdd90,
            R.drawable.birdd91,
            R.drawable.birdd92,
            R.drawable.birdd93,
            R.drawable.birdd94,
            R.drawable.birdd95,
            R.drawable.birdd96,
            R.drawable.birdd97,
            R.drawable.birdd98,
            R.drawable.birdd99,
            R.drawable.birdd100,
            R.drawable.birdd101,
            R.drawable.birdd102,
            R.drawable.birdd104,
            R.drawable.birdd105,
            R.drawable.birdd106,
            R.drawable.birdd107,
            R.drawable.birdd108,
            R.drawable.birdd109,
            R.drawable.birdd110,
            R.drawable.birdd112,
            R.drawable.birdd113,
            R.drawable.birdd114,
            R.drawable.birdd115,
            R.drawable.birdd116,
            R.drawable.birdd117,
            R.drawable.birdd118,
            R.drawable.birdd119,
            R.drawable.birdd120,
            R.drawable.birdd121,
            R.drawable.birdd122,
            R.drawable.birdd123,
            R.drawable.birdd124,
            R.drawable.birdd125,
            R.drawable.birdd126,
            R.drawable.birdd127,
            R.drawable.birdd128,
            R.drawable.birdd129,
            R.drawable.birdd131,
            R.drawable.birdd132,
            R.drawable.birdd133,
            R.drawable.birdd134,
            R.drawable.birdd135,
            R.drawable.birdd136,
            R.drawable.birdd137,
            R.drawable.birdd138,
            R.drawable.birdd139,

            R.drawable.bird1,
            R.drawable.bird2,
            R.drawable.bird3,
            R.drawable.bird4,
            R.drawable.bird5,
            R.drawable.bird6,
            R.drawable.bird7,
            R.drawable.bird8,
            R.drawable.bird9,
            R.drawable.bird10,
            R.drawable.bird11,
            R.drawable.bird12,
            R.drawable.bird13,
            R.drawable.bird14,
            R.drawable.bird15,
            R.drawable.bird16,
            R.drawable.bird17,
            R.drawable.bird18,
            R.drawable.bird19,
            R.drawable.bird20,
            R.drawable.bird21,
            R.drawable.bird22,
            R.drawable.bird23,
            R.drawable.bird24,
            R.drawable.bird25,
            R.drawable.bird26,
            R.drawable.bird27,
            R.drawable.bird28,
            R.drawable.bird29,
            R.drawable.bird30,
            R.drawable.bird31,
            R.drawable.bird32,
            R.drawable.bird33,
            R.drawable.bird34,
            R.drawable.bird35,
            R.drawable.birdd36,
            R.drawable.bird37,
            R.drawable.bird38,
            R.drawable.bird39,
            R.drawable.bird40,
            R.drawable.bird41,
            R.drawable.bird42,
            R.drawable.bird43,
            R.drawable.bird44,
            R.drawable.bird45,
            R.drawable.bird46,
            R.drawable.bird47,
            R.drawable.bird50,
            R.drawable.bird51,
            R.drawable.bird52,
            R.drawable.bird53,
            R.drawable.bird54,
            R.drawable.bird55,
            R.drawable.bird57,
            R.drawable.bird58,
            R.drawable.bird60,
            R.drawable.bird61,
            R.drawable.bird62,
            R.drawable.bird63,
            R.drawable.bird64,
            R.drawable.bird65,
            R.drawable.bird66,
            R.drawable.bird67,
            R.drawable.bird68,
            R.drawable.bird69,
            R.drawable.bird70,
            R.drawable.bird71,
            R.drawable.bird72,
            R.drawable.bird73,
            R.drawable.bird74,
            R.drawable.bird75,
            R.drawable.bird76,
            R.drawable.bird77,
            R.drawable.bird78,
            R.drawable.bird79,
            R.drawable.bird80,
            R.drawable.bird81,
            R.drawable.bird82,
            R.drawable.bird83,
            R.drawable.bird84,
            R.drawable.bird85,
            R.drawable.bird86,
            R.drawable.bird87,
            R.drawable.bird88,
            R.drawable.bird89,
            R.drawable.bird90,
            R.drawable.bird91,
            R.drawable.bird92,
            R.drawable.bird93,
            R.drawable.bird95,
            R.drawable.bird96,
            R.drawable.bird97,
            R.drawable.bird98,
            R.drawable.bird99,
            R.drawable.bird100,
            R.drawable.bird101,
            R.drawable.bird103,
            R.drawable.bird104,
            R.drawable.bird105,
            R.drawable.bird106,
            R.drawable.bird107,
            R.drawable.bird108,
            R.drawable.bird109,
            R.drawable.bird110,
            R.drawable.bird111,
            R.drawable.bird112,
            R.drawable.bird113,
            R.drawable.bird114,
            R.drawable.bird115,
            R.drawable.bird116,
            R.drawable.bird117,
            R.drawable.bird118,
            R.drawable.bird119,
            R.drawable.bird121,
            R.drawable.bird122,
            R.drawable.bird123,
            R.drawable.bird124,
            R.drawable.bird125,
            R.drawable.bird126,
            R.drawable.bird127,
            R.drawable.bird128,
            R.drawable.bird129,
            R.drawable.bird130,
            R.drawable.bird131,
            R.drawable.bird132,
            R.drawable.bird133,
            R.drawable.bird134,
            R.drawable.bird135,
            R.drawable.bird136,
            R.drawable.bird137,
            R.drawable.bird138,
            R.drawable.bird139,

            R.drawable.bird140,
            R.drawable.bird141,
            R.drawable.bird142,
            R.drawable.bird143,
            R.drawable.bird144,
            R.drawable.bird145,
            R.drawable.bird146,
            R.drawable.bird147,
            R.drawable.bird148,
            R.drawable.bird149,
            R.drawable.bird150,
            R.drawable.bird151,
            R.drawable.bird152,
            R.drawable.bird153,
            R.drawable.bird154,
            R.drawable.bird155,
            R.drawable.bird156,
            R.drawable.bird157,
            R.drawable.bird158,
            R.drawable.bird161,
            R.drawable.bird162,
            R.drawable.bird163,
            R.drawable.bird164,
            R.drawable.bird165,
            R.drawable.bird166,
            R.drawable.bird167,
            R.drawable.bird168,
            R.drawable.bird169,

            R.drawable.bird170,
            R.drawable.bird171,
            R.drawable.bird172,
            R.drawable.bird173,
            R.drawable.bird174,
            R.drawable.bird175,
            R.drawable.bird176,
            R.drawable.bird177,
            R.drawable.bird178,
            R.drawable.bird179,

            R.drawable.bird180,
            R.drawable.bird181,
            R.drawable.bird182,
            R.drawable.bird183,
            R.drawable.bird184,
            R.drawable.bird185,
            R.drawable.bird186,
            R.drawable.bird187,
            R.drawable.bird188,
            R.drawable.bird189,

            R.drawable.bird190,
            R.drawable.bird191,
            R.drawable.bird192,
            R.drawable.bird193,
            R.drawable.bird194,
            R.drawable.bird195,
            R.drawable.bird196,
            R.drawable.bird197,
            R.drawable.bird198,
            R.drawable.bird199,

            R.drawable.bird200,
            R.drawable.bird201,
            R.drawable.bird202,
            R.drawable.bird203,
            R.drawable.bird204,
            R.drawable.bird205,
            R.drawable.bird206,
            R.drawable.bird207,
            R.drawable.bird208,

            R.drawable.bird210,
            R.drawable.bird211,
            R.drawable.bird212,
            R.drawable.bird213,
            R.drawable.bird214,
            R.drawable.bird215,
            R.drawable.bird216,
            R.drawable.bird217,
            R.drawable.bird218,

            R.drawable.bird221,
            R.drawable.bird222,
            R.drawable.bird223,
            R.drawable.bird224,
            R.drawable.bird225,
            R.drawable.bird226,
            R.drawable.bird227,
            R.drawable.bird228,
            R.drawable.bird229,

            R.drawable.bird230,
            R.drawable.bird231,
            R.drawable.bird232,
            R.drawable.bird233,




    };

    ImageAdapter(Context context){

        this.context=context;
        inflater = LayoutInflater.from(context);


    }
    ImageAdapter(ImageView imageView){
        this.imageView=imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);

    }


    @Override
    public int getCount() {
        return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(GalImages[position]);


        container.addView(imageView, 0);

        return imageView;
    }



    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
        super.restoreState(state, loader);
    }
}
