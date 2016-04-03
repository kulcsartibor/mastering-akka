package com.packt.masteringakka.bookstore.book

import com.packt.masteringakka.bookstore.Bootstrap
import akka.actor.ActorSystem

/**
 * Bookup for the book service module
 */
object BookBoot extends Bootstrap{

  def bootup(system:ActorSystem) = {
    import system.dispatcher    
    val bookManager = system.actorOf(BookManager.props, BookManager.Name)    
    List(new BookEndpoint(bookManager))
  }
}