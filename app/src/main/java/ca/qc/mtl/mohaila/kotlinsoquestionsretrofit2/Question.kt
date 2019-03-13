package ca.qc.mtl.mohaila.kotlinsoquestionsretrofit2

class Question (val title: String, val link: String, val owner: Owner) {
    override fun toString(): String {
        return title
     }
}


