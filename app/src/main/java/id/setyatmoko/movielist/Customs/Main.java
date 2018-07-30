package id.setyatmoko.movielist.Customs;

public class Main {
    Callback myC = new Callback() {
        @Override
        public void onResponse(String a, String b) {

        }

        @Override
        public void onFailure(String e, String t) {

        }
    };
}
interface Callback{
    void onResponse(String a , String b);
    void onFailure(String e, String t);
}
