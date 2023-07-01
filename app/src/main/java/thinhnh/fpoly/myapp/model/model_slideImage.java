package thinhnh.fpoly.myapp.model;

public class model_slideImage {
    private int Img;
    private String Tv1,Tv2,Tv3;

    public model_slideImage(int img, String tv1, String tv2, String tv3) {
        Img = img;
        Tv1 = tv1;
        Tv2 = tv2;
        Tv3 = tv3;
    }

    public String getTv3() {
        return Tv3;
    }

    public void setTv3(String tv3) {
        Tv3 = tv3;
    }

    public String getTv2() {
        return Tv2;
    }

    public void setTv2(String tv2) {
        Tv2 = tv2;
    }

    public String getTv1() {
        return Tv1;
    }

    public void setTv1(String tv1) {
        Tv1 = tv1;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }
}
