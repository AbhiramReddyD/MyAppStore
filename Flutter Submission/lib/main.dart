import 'package:flutter/material.dart';
void main() {
  runApp(
    MaterialApp(
      title:"Flutter Chennai",
      theme: ThemeData(
        primarySwatch: Colors.red,
      
       ),
       home:HomePage()
    )
  );  
}

class HomePage extends StatelessWidget{
  @override
  Widget build(BuildContext)
  {
    return Scaffold(
      
         appBar: AppBar(
           centerTitle: true ,
          
          title: Text("Gmail",
                )
            
         ),
        body: ListView(
          children: <Widget>[
            ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.blue,
                foregroundColor: Colors.white,
                child:Text("FL"
                ),
                ),
              title: Text('Flutter'),
             subtitle: Text('Start working on Fluter') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
             ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.red,
                foregroundColor: Colors.white,
                child:Text("GM"),
                ),
              title: Text('Gmail Support'),
             subtitle: Text('Mail Recovery Sucessful') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
              ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.yellow,
                foregroundColor: Colors.grey,
                child:Text("G"),
                ),
              title: Text('Google Assistant'),
             subtitle: Text('Say hello to your new Assistant') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
              ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.green,
                foregroundColor: Colors.white,
                child:Text("A"),
                ),
              title: Text('Android Community'),
             subtitle: Text('Added body to mail') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
              ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.orange,
                foregroundColor: Colors.white,
                child:Text("G"),
                ),
              title: Text('Gmail'),
             subtitle: Text('Gmail turns Fifteen') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
              ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.green,
                foregroundColor: Colors.white,
                child:Text("H"),
                ),
              title: Text('Hangouts'),
             subtitle: Text('Say hello to the new Hangouts') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
              ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.grey,
                foregroundColor: Colors.white,
                child:Text("U"),
                ),
              title: Text('Android Update'),
             subtitle: Text('Update, Latest Security Patch') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
              ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.redAccent,
                foregroundColor: Colors.white,
                child:Text("G+"),
                ),
              title: Text('Google+'),
             subtitle: Text('Download your data') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
              ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.blue,
                foregroundColor: Colors.white,
                child:Text("D"),
                ),
              title: Text('Flutter Developers'),
             subtitle: Text('Submission Sucessful') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
              ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.red,
                foregroundColor: Colors.white,
                child:Text("G"),
                ),
              title: Text('Recent Login'),
             subtitle: Text('Your account was acessed recently') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
              ListTile(
              leading: CircleAvatar(
                backgroundColor: Colors.orange,
                foregroundColor: Colors.white,
                child:Text("TF"),
                ),
              title: Text('TF Dev Summit'),
             subtitle: Text('Book your place now!') ,
              onTap: () { /* react to the tile being tapped */ },
              trailing:IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star_border,
                ),
            ),
              ),
            
          ],
        ),
      
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.add),
          onPressed:(){}
        ),
      drawer:Drawer(
        child: ListView(
          //padding: EdgeInsets.all(0),
          children: <Widget>[
            UserAccountsDrawerHeader(
              accountEmail: Text("abhiramreddy@gmail.com"),
              accountName: Text("Abhiram Reddy"),
              currentAccountPicture: CircleAvatar(
                backgroundColor: Colors.white,
                child: Text("AR"),
              ),

            ),
            ListTile(title:Text("All Inbox"),
            leading: IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.inbox,
                color:Colors.red,
            
              ),
            ),
            ),
            ListTile(title:Text("Primary"),
            leading: IconButton(
              onPressed: (){},
              icon:Icon(
                Icons.mail,
                color:Colors.red,
              ),
            ),
            ),
            ListTile(title:Text("Starred"),
            leading: IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.star,
                color:Colors.red,
                
              ),
            ),
            ),
            ListTile(title:Text("Trash"),
            leading: IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.delete,
                color:Colors.red,
                
              ),
            ),
            ),
            ListTile(title:Text("Social"),
            leading: IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.group,
                color:Colors.red,
                
              ),
            ),
            
            ),
            ListTile(title:Text("Sent"),
            leading: IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.send,
                color:Colors.red,
                
              ),
            ),
            ),
            ListTile(title:Text("Settings"),
            leading: IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.settings,
                color:Colors.red,
                
              ),
            ),
            ),
            ListTile(title:Text("Feedback"),
            leading: IconButton(
              onPressed:(){},
              icon:Icon(
                Icons.feedback,
                color:Colors.red,
                
              ),
            ),
            ),
          ],
        ),
      )
       );
  }
}
