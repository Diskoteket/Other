<?php
/*
 * Creates a function to display the custom attribute Author below the product title in single product view for WooCommerce, Wordpress.
 *
 * I don't know if this is the best way to approach this but this function provides a neat display of a custom attribute called Author in WooCommerce, Wordpress.
 * This function relies on the fact that a custom attribute called Author is created. 
 * It also relies on the fact that a product tag with the same name as the author is created.
 *
 * Also note that I do not know if the attribute "Author" is used in any other way because of the fact that my Wordpress installation is in Swedish.
 * I don't think that it matters but what the heck.
 *
 * I am not the best in PHP documentation but I will probably revise this later.
 *
 */

//Creates our new function display_attribute_after_single_product_title
function display_attribute_after_single_product_title(){
   
  //Define a global variable
  global $product;

  // Gets the custom attribute pa_ author
  if( $author = $product->get_attribute('pa_author') ){
    
    // Saves the coma seperated attribute as arrays
    $author_name = explode(', ', $author);
    $author_link = explode(', ', $author);
  }

  //Loops through one of the arrays and replaces some characters so it corresponds with the product tags made separately.
  foreach ($author_link as $i => $item) {
  	$wrong_characters = array(' ','å','ä','ö');
  	$correct_characters = array('-','a','a','o');
  	$author_link_formatted = str_replace($wrong_characters, $correct_characters, $author_link);
  }
  
  //Merges the two arrays
  $author_merged = array_combine($author_name, $author_link_formatted);

  //Loops through the merged array and creates links.
  foreach($author_merged as $link => $name) {
  	$author_result[] = sprintf('<a href="https://example.com/product-tag/%s">%s</a>', $name, $link);
  }
  
  //Just some text displayed below the title
  $By = "By ";
	
  //If the value of $author is more than 0, do the following
  if( sizeof($author) > 0 ){
		
    //If the attribute $author contains ", " i.e more than one author, do the following
    if(strpos($author, ', ' ) !== false){
			
      //Saves the last author in the array to a single
      $author_result_last = array_pop($author_result);
			
      //Join the array with the string created earlier and display the arrays in the following fashion: $author_result[0], $author_result[1] and $author_result_last[0].
      $By .= join(', ', $author_result) . " and $author_result_last";
      echo $By;
    } 
    
  //Else i.e if its only one author, join the array and the string and display it
    else{
      $By .= join($author_result);
      echo $By;
    }
  }
}

//Edit ranking of the Woocommerce hooks to display stuff in the order we want.
remove_action('woocommerce_single_product_summary', 'woocommerce_template_single_price', 10 );

add_action('woocommerce_single_product_summary','display_attribute_after_single_product_title', 10);

add_action( 'woocommerce_single_product_summary', 'woocommerce_template_single_price', 11 );
?>
