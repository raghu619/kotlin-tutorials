package annotations

import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation


// Annotations are a mean of attaching metadata to code
// That is annotations are read by compiler and use to generate code or even logic
//@file:JvmName("InteropFish")
class InteropFish {
    companion object {
        @JvmStatic
        fun interop() {

        }

    }
}

@ImAPlant
class Plant {
    fun trim() {}
    fun fertilize() {}
  // it saying apply OnGet to isGrowing's getter
    @get:OnGet
    val isGrowing: Boolean = true
 // apply Onset to needsFood setter
    @set:Onset
    var needsFood: Boolean = false

}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class Onset

fun reflections() {
    val classObj = Plant::class
    for (method in classObj.declaredMemberProperties) {
        println(method.name)
    }
    // print all annotations
    for (annotation in classObj.annotations) {

        println(annotation.annotationClass.simpleName)
    }

    val annotated = classObj.findAnnotation<ImAPlant>()

    annotated?.apply { println("Found a plant annotation") }

}






