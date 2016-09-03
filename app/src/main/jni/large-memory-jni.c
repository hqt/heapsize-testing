#include <jni.h>

JNIEXPORT jstring JNICALL
Java_memory_hqt_com_heapsizetesting_jnitest_JNIActivity_getMsgFromJni(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "Hello From Jni");
}

JNIEXPORT jobject JNICALL
Java_memory_hqt_com_heapsizetesting_jnitest_JNIActivity_getBigDataFromJni(JNIEnv *env, jobject instance, jint memory) {

     // allocate memory at native layer using Java layer. Still meet restriction about memory
     // jbyteArray ret = (*env)->NewByteArray(env, memory);

     unsigned char* buffer = (unsigned char*) malloc(memory);
     jobject directBuffer = (*env)->NewDirectByteBuffer(env, buffer, memory);
     return directBuffer;
}

JNIEXPORT void JNICALL
Java_memory_hqt_com_heapsizetesting_jnitest_JNIActivity_deallocateData(JNIEnv *env, jobject instance, jobject directBuffer) {

    unsigned char* buffer;
    buffer = (unsigned char*) (*env)->GetDirectBufferAddress(env, directBuffer);
    free(buffer);
}

