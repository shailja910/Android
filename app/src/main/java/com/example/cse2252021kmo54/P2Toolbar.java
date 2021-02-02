package com.example.cse2252021kmo54;
/* toolbar: it is advance form of actionbar introduced in API21.toolbar is shown at the same place (top horizontal) as ActionBar So,we need to make
 the default ActionBar invisible by :
         resource->values->styles: instead of DarkActionBar ,change it to NoActionBar. otherwise you will get overlapping error

--> if you are working on upto 28 API then add the V7 support material design dependency to gradle i.e. implementation 'com.android.support:design:28.0.0'
otherwise for API>28 add the adroidx material design dependency i.e.implementation 'com.google.android.material:material:1.0.0-rc01'

-->Now we have to get the support of ActionBar for the current toolbar.   using setSupportActionBar(toolbar_reference_name) to interact with it through java, this is must

-->Toolbar is better version Actionbar.  Toolbar is a ViewGroup that  can be  placed anywhere in your XML layouts.  Toolbar's appearance and
behavior  can be more easily customized than the ActionBar.

-->we will use androidx.appcompat.widget.Toolbar   for API >28   and android v7.support.widget.Toolbar for API<29

 XML associated :activity_p2_toolbar.xml
 menu file associated: res->menu folder->tosearchmenu   (/*to create a "Menu" type file named "my_menu" : right click resource folder-> new->Android
                                                        resource directory->give it name "menu"-> select resource type "Menu" ans then Ok.
                                                        Once "Menu" folder will get created. right click on menu folder->new->menu resource file->
                                                         give it name ->then okay. menu folder consist of file "my_menu" and then we have to add
                                                         items to that file)
 we can add following components to toolbar.
1.Navigation Button: It may be a Navigation menu toggle, up arrow, close, done, collapse or any other glyph of the app’s choosing.
Brand Logo Image: It may extend to the height of the toolbar and can be arbitrarily wide.

2.Title and SubTitle and colors to them: A title should be a signpost for the current position of Toolbar’s navigation hierarchy and the content contained
there. Subtitle represents any extended information about the current content. If an app uses a logo then it should strongly consider
omitting a title and subtitle.

3.One or More Custom Views: An Application may add arbitrary child views to the Toolbar. If child view’s Toolbar.LayoutParams indicates
CENTER_HORIZONTAL Gravity then view will attempt to center within the available space remaining in the Toolbar after all other element’s
 have been measured.

4.Action Menu: The menu of Actions will pin to the end of the Toolbar offering a few important, typical or frequent actions along with an
optional overflow menu for additional actions. Action buttons are aligned vertically within the Toolbar’s minimum height if we set.

 */
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class P2Toolbar extends AppCompatActivity {
    ArrayAdapter adapter;   //make it instance variable so that it can be used outside onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_toolbar);
        Toolbar tb1 = findViewById(R.id.tb1);
        setSupportActionBar(tb1); // Setting/replace toolbar as the ActionBar

        //create a listview to add to the activity then perform search action on it from the tool bar
        ListView lv=findViewById(R.id.listView);
        String fruits[]={"Apple","mango","banana","strawberry","grapes","jackfruit","malta","melon"};
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,fruits);
        lv.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {        getMenuInflater().inflate(R.menu.tosearchmenu,menu);
        MenuItem search = menu.findItem(R.id.search_id);   //from menu file   choosing the item from options menu on which you will be choosing the search operation to happen

        /*SearchView is the predefined class to perform search operation,it must be declared with the item of options menu defined in the menu.xml
         file,clicking on which search will happen .It is done using : app:actionViewClass="android.widget.SearchView"  as in this program it is done
         in tosearchmenu.xml file item named search */
        SearchView sv = (SearchView) search.getActionView();


        /*after connecting the searchview with the item named "search" of menu, apply setOnQueryTextListener on this,the moment you start typing
        something in the seachView opened in toolbar. It will search the item from listview */
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {            @Override
        public boolean onQueryTextSubmit(String query)
        {

            //become active when you click enter after writing something in searchview in toolbar
            Toast.makeText(getApplicationContext(),query,Toast.LENGTH_SHORT).show();
            return true;
        }

            public boolean onQueryTextChange(String newText){
            //becomes active whenver you write any alphabet in the searchview
                adapter.getFilter().filter(newText);  //it will filter out the items from listview depending on the match with newText.
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    /*onOptionsItemSelected  is a predefined method to perform click
    operations on items of Option menu.*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.aboutus:
                Toast.makeText(this,"About Us Clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.setting:
                Toast.makeText(this,"Setting Clicked",Toast.LENGTH_SHORT).show();
                break;

            case R.id.users:
                Toast.makeText(this,"Users Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_id:
                Toast.makeText(this,"Search Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cart:
                Toast.makeText(this,"Cart Clicked",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



