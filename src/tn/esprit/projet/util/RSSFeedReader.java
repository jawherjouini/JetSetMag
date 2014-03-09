/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.esprit.projet.util;

import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.atom.Link;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEnclosureImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author tasnim
 */

public class RSSFeedReader {
    
    public List<String> getImages (String url){
         List<String> images= new ArrayList<String>();
        try {
           
            URL feedUrl = new URL(url);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            
            Iterator entryIter = feed.getEntries().iterator();
            while (entryIter.hasNext()) {
                SyndEntry entry = (SyndEntry) entryIter.next();
                List<SyndEnclosure> encls = entry.getEnclosures();
                if(!encls.isEmpty()){
                    for(SyndEnclosure e : encls){
                        String imgURL = e.getUrl().toString();
                        images.add(imgURL);
                    }
                }
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FeedException ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }
    
    public ObservableList<String> getTitle(String url) {
        
         ObservableList<String> titles = FXCollections.observableArrayList();
        try {
            URL feedUrl = new URL(url);
            SyndFeedInput input = new SyndFeedInput();
            System.out.println(feedUrl);
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            Iterator entryIter = feed.getEntries().iterator();
            while (entryIter.hasNext()) {
                SyndEntry entry = (SyndEntry) entryIter.next();
                 String desc = entry.getTitleEx().getValue();
                  String s = desc.replaceAll("<[^>]*>", "")+"\n";
                  s = s.replaceAll("&nbsp", "")+"\n";
//                  String s2 = entry.getEnclosures().toString()+"\n";
//                  s2 = s2.replaceAll("Synd[^>]*http", "")+"\n";
//                  s2 = s2.substring(1, s2.length() - 1)+"\n";
//                  s2 = "http" + s2+"\n";
 //                 String event = s + s2 + entry.getTitle();
                  titles.add(s);
//                  }                       
                }
        }catch(Exception ex){}
        return titles;
    
    }
    
      public List<String> getItems(String url) {
        // System.out.println(url);
    		
        List<String> events = new ArrayList<String>();
        try {
            URL feedUrl = new URL(url);
            /* SyndFeedInput: parser to process RSS feeds into SyndFeed instance*/
            
            SyndFeedInput input = new SyndFeedInput();

            /* Load the RSS feed
             * XmlReader: reading an XML document
             * SyndFeed: rss feed
             */ 
            
            System.out.println(feedUrl);
            SyndFeed feed = input.build(new XmlReader(feedUrl));
            
//        
//            System.out.println("Feed Author: "+ feed.getAuthor());
//             System.out.println("Feed Title: "+ feed.getTitle());
//             System.out.println("Feed Description: "+ feed.getDescription());
//             System.out.println("Feed Version: "+ feed.getFeedType());
             // Iterate through feed items, display each item title
            //System.out.println(feed.getEntries().toString());  
           
            Iterator entryIter = feed.getEntries().iterator();
            while (entryIter.hasNext()) {
                SyndEntry entry = (SyndEntry) entryIter.next();
               
                //if (entry.getCategories().toString().contains("Cinéma")) {
                
//                List<SyndEnclosure> encls = entry.getEnclosures();
//                if(!encls.isEmpty()){
//                  for(SyndEnclosure e : encls){
//                  String imgURL = e.getUrl().toString();
//                  System.out.println(imgURL);
                 String desc = entry.getDescription().getValue();
                  String s = desc.replaceAll("<[^>]*>", "")+"\n";
                  s = s.replaceAll("&nbsp", "")+"\n";
                  String s2 = entry.getEnclosures().toString()+"\n";
                  s2 = s2.replaceAll("Synd[^>]*http", "")+"\n";
                  s2 = s2.substring(1, s2.length() - 1)+"\n";
                  s2 = "http" + s2+"\n";
                  String event = s + s2 + entry.getTitle();
                  events.add(event);
//                  }                       
                }
                //List<SyndEnclosure> encls = entry.getEnclosures();
//                List<String> images= new ArrayList<String>();
//                if(!encls.isEmpty()){
//                  for(SyndEnclosure e : encls){
//                  String imgURL = e.getUrl().toString();
//                  images.add(imgURL);
//                  }
//                }
                
            
  
 //               List<SyndEnclosure> enclosures = new ArrayList();
                //enclosures.get(0).getUrl();
//                enclosures.add( createSyndEnclosure (feed, entry,feedUrl));
//                entry.setEnclosures(enclosures);
////                    
                 
                //String a = entry.getContents().get(1).toString();//.getUri().toString();
              
                
                    
//                    $film = "Harry Potter et les reliques de la mort" ;
//                	$url = "http://www.allocine.fr/recherche/?q=".$film."" ;
//                	$remplacement = "%20" ;
//                	$url = str_replace( " ", $remplacement, $url ) ;
//                	$html = file_get_contents( $url );
//                	echo $html;
                	
                //}
            }
            
  

         catch (Exception ex) {
            Logger.getLogger(RSSFeedReader.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return events;
        
        
        
    }
    
      public SyndEnclosure createSyndEnclosure(Feed feed, Entry entry,
    		            Link link) {
    		        SyndEnclosure syndEncl = new SyndEnclosureImpl();
    		        syndEncl.setUrl(link.getHref());
    		        syndEncl.setType(link.getType());
    		        syndEncl.setLength(link.getLength());
    		       return syndEncl;
    		     }
    		     

}
