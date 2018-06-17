package com.example.mayank.saksham;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Learn extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.logo).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.a1,
                R.drawable.b1,
                R.drawable.c1,
                R.drawable.d1,
                R.drawable.e1,
                R.drawable.f1,
                R.drawable.g1,
                R.drawable.h1,
                R.drawable.i1,
                R.drawable.j1,
                R.drawable.k1,
                R.drawable.l1,
                R.drawable.m1,
                R.drawable.n1,
                R.drawable.o1,
                R.drawable.p1,
                R.drawable.q1,
                R.drawable.r1,
                R.drawable.s1,
                R.drawable.t1,
                R.drawable.u1,
                R.drawable.v1,
                R.drawable.w1,
                R.drawable.x1,
                R.drawable.y1,
                R.drawable.z1
        };

        Album a = new Album("Morse Code: A",covers[0]);
        albumList.add(a);

        a = new Album("Morse Code: B",covers[1]);
        albumList.add(a);

        a = new Album("Morse Code: C",covers[2]);
        albumList.add(a);

        a = new Album("Morse Code: D",covers[3]);
        albumList.add(a);

        a = new Album("Morse Code: E",covers[4]);
        albumList.add(a);

        a = new Album("Morse Code: F",covers[5]);
        albumList.add(a);

        a = new Album("Morse Code: G",covers[6]);
        albumList.add(a);

        a = new Album("Morse Code: H",covers[7]);
        albumList.add(a);

        a = new Album("Morse Code: I",covers[8]);
        albumList.add(a);

        a = new Album("Morse Code: J",covers[9]);
        albumList.add(a);

        Album b = new Album("Morse Code: K",covers[10]);
        albumList.add(b);

        a = new Album("Morse Code: L",covers[11]);
        albumList.add(a);

        a = new Album("Morse Code: M",covers[12]);
        albumList.add(a);

        a = new Album("Morse Code: N",covers[13]);
        albumList.add(a);

        a = new Album("Morse Code: O",covers[14]);
        albumList.add(a);

        a = new Album("Morse Code: P",covers[15]);
        albumList.add(a);

        a = new Album("Morse Code: Q",covers[16]);
        albumList.add(a);

        a = new Album("Morse Code: R",covers[17]);
        albumList.add(a);

        a = new Album("Morse Code: S",covers[18]);
        albumList.add(a);

        a = new Album("Morse Code: T",covers[19]);
        albumList.add(a);

        Album c = new Album("U",covers[20]);
        albumList.add(c);

        a = new Album("V",covers[21]);
        albumList.add(a);

        a = new Album("W",covers[22]);
        albumList.add(a);

        a = new Album("X",covers[23]);
        albumList.add(a);

        a = new Album("Y",covers[24]);
        albumList.add(a);

        a = new Album("Z",covers[25]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
