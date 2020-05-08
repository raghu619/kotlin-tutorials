package Acquarium

import kotlin.math.PI

open class Aquarium(var length:Int =100, var width:Int =20,var height:Int =40)  {

   // bad proatice
//    var width :Int =length
//    var height :Int =width
//    var length :Int =height
//


   open var volume :Int
         get() = width * height * length /1000
         set(value) {
             height =(value*1000)/(width*length)

         }
    open var water = volume * 0.9
   constructor(numberOfFish:Int):this(){
          val water :Int = numberOfFish *2000  //cm3
          val tank = water + water * 0.1
          height = (tank/(length*width)).toInt()

   }
}




class TowerTank():Aquarium(){
    override  var water = volume * 0.8
    override  var volume :Int
           get() = (width*height*length/1000* PI).toInt()
           set(value) {
               height = (value*1000)/ (width * length)
           }

}




class  Fish(val friendly:Boolean= true,volumeNeeded :Int){

    val size :Int
    constructor():this (true,9){

        println("running secondary constructor")
    }
    init {
        println("first init block")
    }

    init {
         if(friendly){
             size = volumeNeeded

         }else{
             size =volumeNeeded*2
         }


    }
}

