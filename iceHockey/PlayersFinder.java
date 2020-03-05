package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;

public class PlayersFinder implements IPlayersFinder {

	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
		boolean flag=true;int b=0;
		boolean flag1=true;
		Point [] coordinates = new Point[2500];
		for(int x=0;x<2500;x++) {coordinates[x]=new Point(0,0);}
		if (photo.length<1 || photo[0].length()<1) {
			throw new NullPointerException("empty img");
		}
		char[][] findplayer = new char [photo.length][photo[0].length()];
		 int [][] check = new int [photo.length+2][photo[0].length()+2];
	for(int i=0;i<photo.length;i++) {
		int x=0;
		for(int j=0;j<photo[0].length();j++) {
			findplayer[i][j]=photo[i].charAt(x++);
		} 
	}
 for(int i=1;i<photo.length+1;i++) {
	 for(int j=1;j<photo[0].length()+1;j++) {
		 if (Character.getNumericValue(findplayer[i-1][j-1])==team) {
			 check[i][j]=1;
		 }
		 else check[i][j]=0;
	 } 
 } 
 while (flag) {
	 flag=false;
	 for(int i=1;i<photo.length+1;i++) {
		 for(int j=1;j<photo[0].length()+1;j++) {
			 if (check[i][j] !=0) {
			 flag =true;break;}}}	 
	  int counter =0;
	 for(int i=1;i<photo.length+1;i++) {
		 for( int j=1;j<photo[0].length()+1;j++) {
			 if(check[i][j]!=0) {flag=true;
			 check[i][j]=10;
			 counter=0;counter++;  flag1=true;
			 while (flag1) {
			flag1= false;	
				 for(int k=i;k<photo.length+1;k++) {
					 for(int f=1;f<photo[0].length()+1;f++) {
					 if((check[k][f]==1) && ((check[k+1][f]==10) || (check[k-1][f]==10) || (check[k][f+1]==10) || (check[k][f-1]==10))){
						 check[k][f]=10;
						 counter++;
						 flag1=true;
					 
					 }
					 } 
			}
		 }
			 
		if (counter *4 >=threshold ) {
			int maxx=0,maxy=0,minx=100,miny=100;
			for(int e=0;e<photo.length;e++) {
				for(int y=0;y<photo[0].length();y++) {
					if (check[e+1][y+1]==10) {
						if(y>maxx) {
							maxx=y;
						}
						if(y<minx) {
							minx=y;
						}
						if(e>maxy) {
							maxy=e;
						}
						if(e<miny) {
							miny=e;
						}


					}
				}
			}
		coordinates[b++]=new Point(maxx+minx+1,maxy+miny+1); 
		for(int d=0;d<photo.length+1;d++) {
			for(int a =0;a<photo[0].length()+1;a++) {
				if(check[d][a]==10) {
					check[d][a]=0;
				}
			}
		}
		}
		else if (counter *4 < threshold) {
			for(int d=0;d<photo.length+1;d++) {
				for(int a =0;a<photo[0].length()+1;a++) {
					if(check[d][a]==10) {
						check[d][a]=0;
					}
				}
			}
		}
		 }
		 }}} 
 
	Point [] result = new Point [b];
	for(int g=0;g<b;g++) {
		if (coordinates[g].x!=0 &&coordinates[g].y!=0) {
			result[g]=coordinates[g];
		}
	}
	return result;}
	
	}
	
