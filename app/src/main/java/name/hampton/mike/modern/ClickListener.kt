package name.hampton.mike.modern

import android.view.View


interface ClickListener<T> {
    fun onClick(view: View?, data: T, position: Int)
}