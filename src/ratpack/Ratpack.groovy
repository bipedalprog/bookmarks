import com.bipedalprogrammer.bookmarks.services.BookmarkServer
import com.bipedalprogrammer.bookmarks.model.Bookmark

import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

BookmarkServer bookmarkServer = new BookmarkServer()

bookmarkServer.addBookmark(new Bookmark('http://localhost:5050', 'This Page', ['Sample'], 'Something to get us started.'))

ratpack {
  handlers {
    get {
      render groovyTemplate("index.html", title: "Bookmarks", bookmarks: bookmarkServer.list())
    }
        
    assets "public"
  }
}
