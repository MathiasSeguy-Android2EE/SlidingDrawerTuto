/**
* <ul>
* Android Tutorial, An <strong>Android2EE</strong>'s project.</br>
* Produced by <strong>Dr. Mathias SEGUY</strong> with the smart contribution of <strong>Julien PAPUT</strong>.</br>
* Delivered by <strong>http://android2ee.com/</strong></br>
* Belongs to <strong>Mathias Seguy</strong></br>
* ****************************************************************************************************************</br>
* This code is free for any usage but can't be distribute.</br>
* The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
* The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* For any information (Advice, Expertise, J2EE or Android Training, Rates, Business):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
* Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br>
* Sa propriété intellectuelle appartient à la société <strong>ST Informatique Services</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* Pour tous renseignements (Conseil, Expertise, Formations J2EE ou Android, Prestations, Forfaits):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Les meilleurs des Ingénieurs Java-J2EE nous rejoignent pour participer avec nous à la grande aventure</br>
* de l’informatique des prochaines décennies.</br>
* N'hésitez pas à nous contacter.</br>
* *****************************************************************************************************************</br>
* com.android2ee.android.tuto</br>
* 25 mars 2011</br>
*/
package com.android2ee.android.tuto;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author (Julien PAPUT sous la direction du Dr. Mathias Séguy)
 * @goals This class aims to:
 *        <ul>
 *        <li>This class init the GridView</li>
 *        </ul>
 */
public class SlidingDrawerTuto extends Activity {
	
	/******************************************************************************************/
	/** Attributes **************************************************************************/
	/******************************************************************************************/
	//The gallery
	private Gallery gallery;
	//The ImageButton
	private ImageButton imageButton;
	//The drawable
	private Drawable drawableButton; 
	private Resources resources;
	//The ImageAdapter
	private MyImageAdapter imageAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //load the project'sresources 
        resources = getResources();
        //Get the default image
        drawableButton = resources.getDrawable(R.drawable.ic_android2ee_bleu);
        
        //Set the default image to the ImageButton
        imageButton = (ImageButton) findViewById(R.id.myImage);
        imageButton.setBackgroundDrawable(drawableButton);
            
        //Initialisation of the Gallery
        gallery = (Gallery) findViewById(R.id.myGallery);
        imageAdapter=new MyImageAdapter(this);
        gallery.setAdapter(imageAdapter);
        
      //Call when an element of the GridView is selected
        gallery.setOnItemClickListener(new OnItemClickListener(){
        	//Display image selected by user
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				displayImageInSelectedComponent(position);			
			}

        });
    }
    
    /**
     * @param position : the position of selected image into the GridView
     */
    private void displayImageInSelectedComponent(int position){
    	//Set the selected image into the ImageButton 	
    	imageButton.setBackgroundResource((Integer)imageAdapter.getItem(position));
    	  	
    }
}