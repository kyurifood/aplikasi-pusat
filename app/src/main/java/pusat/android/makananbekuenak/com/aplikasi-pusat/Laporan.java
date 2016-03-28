package pusat.android.makananbekuenak.com.aplikasi_pusat;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;


public class Laporan extends Activity {

    private ListView mListView;
    private static int count = 0;
    private static boolean isNotAdded = true;

    final CustomAdapter adapter = new CustomAdapter(this);
    final static String[] textviewContent = {
            "Content1","Content2",
    };

    /**
     * To save checked items, and <b>re-add</b> while scrolling.
     */
    SparseBooleanArray mChecked = new SparseBooleanArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view);


        if (isNotAdded) {


            isNotAdded = false;
        }

        /*
         * Set Adapter After Adding Header
         */
        mListView.setAdapter(adapter);

    }
    public void buton01(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.Produk.class);
        startActivity(panggil_class);
    }

    /*
     * CustomAdapter
     */
    public class CustomAdapter extends BaseAdapter {

        Activity sActivity;

        public CustomAdapter(final Activity mActivity) {
            this.sActivity = mActivity;
        }

        @Override
        public int getCount() {

            /*
             * Length of our listView
             */
            count = Laporan.textviewContent.length;
            return count;
        }

        @Override
        public Object getItem(int position) {

            return position;
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View mView = convertView;

            if (mView == null) {

                /*
                 * LayoutInflater
                 */
                final LayoutInflater sInflater = (LayoutInflater) sActivity.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);

                /*
                 * Inflate Custom List View
                 */
                mView = sInflater.inflate(R.layout.custom_list_view, null, false);

            }



            final ImageView sIMG = (ImageView) mView.findViewById(R.id.imageView);

            final CheckBox mCheckBox = (CheckBox) mView.findViewById(
                    R.id.checkBox);

            sIMG.setImageResource(R.drawable.produk);



            /*
             * Set CheckBox "TRUE" or "FALSE" if mChecked == true
             */

            mCheckBox.setChecked((mChecked.get(position)==true));



            return mView;
        }
        /*
         * Find if all values are checked.
         */
        protected boolean isAllValuesChecked() {

            for (int i = 0; i < count; i++) {
                if (!mChecked.get(i)) {
                    return false;
                }
            }

            return true;
        }

    }
}