import com.bipedalprogrammer.bookmarks.services.BookmarkServer
import com.bipedalprogrammer.bookmarks.model.Bookmark
import ratpack.form.Form

import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

BookmarkServer bookmarkServer = new BookmarkServer()

bookmarkServer.addBookmark(new Bookmark('http://localhost:5050', 'This Page', ['Sample'], 'Something to get us started.'))

ratpack {
  handlers {
    get {
      render groovyTemplate("index.html", title: "Bookmarks", bookmarks: bookmarkServer.list())
    }

    post('bookmarks') {
      Form form = parse(Form)
      if (form.title && form.url) {
        List tags = []
        if (form.tags) {
          String tagString = form.tags
          String[] stringArray = tagString.split(',')
          stringArray.each({tags << it.trim()})
        }
        bookmarkServer.addBookmark(new Bookmark(form.url, form.title, tags, form.note))
        println "We now have ${bookmarkServer.list().size()} bookmarks."
        redirect('/')
      }
    }

    assets "public"
  }
}
