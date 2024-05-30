#include <jni.h>


JNIEXPORT jstring JNICALL
Java_com_pew_monkeynews_utils_ApiKeyProvider_getApi(JNIEnv *env, jobject thiz) {
    return (*env)->NewStringUTF(env, "083e6d704be74c5b8c57f255c44d51a9");
}