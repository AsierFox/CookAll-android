package com.devdream.cookall.chat

import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.devdream.cookall.core.dto.ChatDTO
import com.stfalcon.chatkit.R
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.commons.ViewHolder
import com.stfalcon.chatkit.commons.models.IDialog
import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.utils.DateFormatter

import java.lang.reflect.Constructor
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.Date

import android.view.View.GONE
import android.view.View.VISIBLE

class DialogsListAdapter
/**
 * For custom list item layout and custom view holder
 *
 * @param itemLayoutId custom list item resource id
 * @param holderClass  custom view holder class
 * @param imageLoader  image loading method
 */
(@param:LayoutRes private val itemLayoutId: Int, private val holderClass: Class<out BaseDialogViewHolder<*>>,
        /**
         * @return registered image loader
         */
 /**
  * Register a callback to be invoked when image need to load.
  *
  * @param imageLoader image loading method
  */
 var imageLoader: ImageLoader?) : RecyclerView.Adapter<DialogsListAdapter.BaseDialogViewHolder<*>>() {

    private var items: MutableList<ChatDTO>? = ArrayList()
    private var onDialogClickListener: OnDialogClickListener<ChatDTO>? = null
    private var onDialogViewClickListener: OnDialogViewClickListener<ChatDTO>? = null
    private var onLongItemClickListener: OnDialogLongClickListener<ChatDTO>? = null
    /**
     * @return on view long click callback
     */
    /**
     * Register a callback to be invoked when item view is long clicked.
     *
     * @param clickListener on long click item callback
     */
    var onDialogViewLongClickListener: OnDialogViewLongClickListener<ChatDTO>? = null
    private var dialogStyle: DialogListStyle? = null
    private var datesFormatter: DateFormatter.Formatter? = null

    /**
     * Returns `true` if, and only if, dialogs count in adapter is non-zero.
     *
     * @return `true` if size is 0, otherwise `false`
     */
    val isEmpty: Boolean
        get() = items!!.isEmpty()

    /**
     * For default list item layout and view holder
     *
     * @param imageLoader image loading method
     */
    constructor(imageLoader: ImageLoader) : this(R.layout.item_dialog, DialogViewHolder<*>::class.java, imageLoader) {}

    /**
     * For custom list item layout and default view holder
     *
     * @param itemLayoutId custom list item resource id
     * @param imageLoader  image loading method
     */
    constructor(@LayoutRes itemLayoutId: Int, imageLoader: ImageLoader) : this(itemLayoutId, DialogViewHolder<*>::class.java, imageLoader) {}

    override fun onBindViewHolder(holder: BaseDialogViewHolder<*>, position: Int) {
        holder.setImageLoader(imageLoader)
        holder.setOnDialogClickListener(onDialogClickListener)
        holder.setOnDialogViewClickListener(onDialogViewClickListener)
        holder.setOnLongItemClickListener(onLongItemClickListener)
        holder.setOnDialogViewLongClickListener(onDialogViewLongClickListener)
        holder.setDatesFormatter(datesFormatter)
        holder.onBind(items!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseDialogViewHolder<*> {
        val v = LayoutInflater.from(parent.context).inflate(itemLayoutId, parent, false)
        //create view holder by reflation
        try {
            val constructor = holderClass.getDeclaredConstructor(View::class.java)
            constructor.isAccessible = true
            val baseDialogViewHolder = constructor.newInstance(v)
            if (baseDialogViewHolder is DialogViewHolder<*>) {
                (baseDialogViewHolder as DialogViewHolder<*>).setDialogStyle(dialogStyle)
            }
            return baseDialogViewHolder
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    /**
     * @return size of dialogs list
     */
    override fun getItemCount(): Int {
        return items!!.size
    }

    /**
     * remove item with id
     *
     * @param id dialog i
     */
    fun deleteById(id: String) {
        for (i in items!!.indices) {
            if (items!![i].getId() == id) {
                items!!.removeAt(i)
                notifyItemRemoved(i)
            }
        }
    }

    /**
     * clear dialogs list
     */
    fun clear() {
        if (items != null) {
            items!!.clear()
        }
        notifyDataSetChanged()
    }

    /**
     * Set dialogs list
     *
     * @param items dialogs list
     */
    fun setItems(items: MutableList<ChatDTO>) {
        this.items = items
        notifyDataSetChanged()
    }

    /**
     * Add dialogs items
     *
     * @param newItems new dialogs list
     */
    fun addItems(newItems: List<ChatDTO>?) {
        if (newItems != null) {
            if (items == null) {
                items = ArrayList()
            }
            val curSize = items!!.size
            items!!.addAll(newItems)
            notifyItemRangeInserted(curSize, items!!.size)
        }
    }

    /**
     * Add dialog to the end of dialogs list
     *
     * @param dialog dialog item
     */
    fun addItem(dialog: ChatDTO) {
        items!!.add(dialog)
        notifyItemInserted(0)
    }

    /**
     * Add dialog to dialogs list
     *
     * @param dialog   dialog item
     * @param position position in dialogs lost
     */
    fun addItem(position: Int, dialog: ChatDTO) {
        items!!.add(position, dialog)
        notifyItemInserted(position)
    }

    /**
     * Update dialog by position in dialogs list
     *
     * @param position position in dialogs list
     * @param item     new dialog item
     */
    fun updateItem(position: Int, item: ChatDTO) {
        if (items == null) {
            items = ArrayList()
        }
        items!![position] = item
        notifyItemChanged(position)
    }

    /**
     * Update dialog by dialog id
     *
     * @param item new dialog item
     */
    fun updateItemById(item: ChatDTO) {
        if (items == null) {
            items = ArrayList()
        }
        for (i in items!!.indices) {
            if (items!![i].getId() == item.getId()) {
                items!![i] = item
                notifyItemChanged(i)
                break
            }
        }
    }

    /**
     * Update last message in dialog and swap item to top of list.
     *
     * @param dialogId Dialog ID
     * @param message  New message
     * @return false if dialog doesn't exist.
     */
    fun updateDialogWithMessage(dialogId: String, message: IMessage): Boolean {
        var dialogExist = false
        for (i in items!!.indices) {
            if (items!![i].getId() == dialogId) {
                items!![i].setLastMessage(message)
                notifyItemChanged(i)
                if (i != 0) {
                    Collections.swap(items!!, i, 0)
                    notifyItemMoved(i, 0)
                }
                dialogExist = true
                break
            }
        }
        return dialogExist
    }

    /**
     * Sort dialog by last message date
     */
    fun sortByLastMessageDate() {
        Collections.sort(items!!) { o1, o2 ->
            if (o1.getLastMessage().createdAt.after(o2.getLastMessage().createdAt)) {
                -1
            } else if (o1.getLastMessage().createdAt.before(o2.getLastMessage().createdAt)) {
                1
            } else
                0
        }
        notifyDataSetChanged()
    }

    /**
     * Sort items with rules of comparator
     *
     * @param comparator Comparator
     */
    fun sort(comparator: Comparator<ChatDTO>) {
        Collections.sort(items!!, comparator)
        notifyDataSetChanged()
    }

    /**
     * @return the item click callback.
     */
    fun getOnDialogClickListener(): OnDialogClickListener<*>? {
        return onDialogClickListener
    }

    /**
     * Register a callback to be invoked when item is clicked.
     *
     * @param onDialogClickListener on click item callback
     */
    fun setOnDialogClickListener(onDialogClickListener: OnDialogClickListener<ChatDTO>) {
        this.onDialogClickListener = onDialogClickListener
    }

    /**
     * @return the view click callback.
     */
    fun getOnDialogViewClickListener(): OnDialogViewClickListener<*>? {
        return onDialogViewClickListener
    }

    /**
     * Register a callback to be invoked when dialog view is clicked.
     *
     * @param clickListener on click item callback
     */
    fun setOnDialogViewClickListener(clickListener: OnDialogViewClickListener<ChatDTO>) {
        this.onDialogViewClickListener = clickListener
    }

    /**
     * @return on long click item callback
     */
    fun getOnLongItemClickListener(): OnDialogLongClickListener<*>? {
        return onLongItemClickListener
    }

    /**
     * Register a callback to be invoked when item is long clicked.
     *
     * @param onLongItemClickListener on long click item callback
     */
    fun setOnDialogLongClickListener(onLongItemClickListener: OnDialogLongClickListener<ChatDTO>) {
        this.onLongItemClickListener = onLongItemClickListener
    }

    /**
     * Sets custom [DateFormatter.Formatter] for text representation of last message date.
     */
    fun setDatesFormatter(datesFormatter: DateFormatter.Formatter) {
        this.datesFormatter = datesFormatter
    }

    //TODO ability to set style programmatically
    internal fun setStyle(dialogStyle: DialogListStyle) {
        this.dialogStyle = dialogStyle
    }

    /*
    * LISTENERS
    * */
    interface OnDialogClickListener<DIALOG : IDialog<*>> {
        fun onDialogClick(dialog: DIALOG)
    }

    interface OnDialogViewClickListener<DIALOG : IDialog<*>> {
        fun onDialogViewClick(view: View, dialog: DIALOG)
    }

    interface OnDialogLongClickListener<DIALOG : IDialog<*>> {
        fun onDialogLongClick(dialog: DIALOG)
    }

    interface OnDialogViewLongClickListener<DIALOG : IDialog<*>> {
        fun onDialogViewLongClick(view: View, dialog: DIALOG)
    }

    /*
    * HOLDERS
    * */
    abstract class BaseDialogViewHolder<DIALOG : IDialog<*>>(itemView: View) : ViewHolder<DIALOG>(itemView) {

        protected var imageLoader: ImageLoader? = null
        protected var onDialogClickListener: OnDialogClickListener<DIALOG>? = null
        protected var onLongItemClickListener: OnDialogLongClickListener<DIALOG>? = null
        protected var onDialogViewClickListener: OnDialogViewClickListener<DIALOG>? = null
        protected var onDialogViewLongClickListener: OnDialogViewLongClickListener<DIALOG>? = null
        protected var datesFormatter: DateFormatter.Formatter? = null

        internal fun setImageLoader(imageLoader: ImageLoader?) {
            this.imageLoader = imageLoader
        }

        fun setOnDialogClickListener(onDialogClickListener: OnDialogClickListener<DIALOG>?) {
            this.onDialogClickListener = onDialogClickListener
        }

        fun setOnDialogViewClickListener(onDialogViewClickListener: OnDialogViewClickListener<DIALOG>?) {
            this.onDialogViewClickListener = onDialogViewClickListener
        }

        fun setOnLongItemClickListener(onLongItemClickListener: OnDialogLongClickListener<DIALOG>?) {
            this.onLongItemClickListener = onLongItemClickListener
        }

        fun setOnDialogViewLongClickListener(onDialogViewLongClickListener: OnDialogViewLongClickListener<DIALOG>?) {
            this.onDialogViewLongClickListener = onDialogViewLongClickListener
        }

        fun setDatesFormatter(dateHeadersFormatter: DateFormatter.Formatter?) {
            this.datesFormatter = dateHeadersFormatter
        }
    }

    class DialogViewHolder<DIALOG : IDialog<*>>(itemView: View) : BaseDialogViewHolder<DIALOG>(itemView) {
        protected var dialogStyle: DialogListStyle? = null
        protected var container: ViewGroup
        protected var root: ViewGroup? = null
        protected var tvName: TextView? = null
        protected var tvDate: TextView? = null
        protected var ivAvatar: ImageView? = null
        protected var ivLastMessageUser: ImageView? = null
        protected var tvLastMessage: TextView? = null
        protected var tvBubble: TextView? = null
        protected var dividerContainer: ViewGroup? = null
        protected var divider: View? = null

        init {
            root = itemView.findViewById<View>(R.id.dialogRootLayout) as ViewGroup
            container = itemView.findViewById<View>(R.id.dialogContainer) as ViewGroup
            tvName = itemView.findViewById<View>(R.id.dialogName) as TextView
            tvDate = itemView.findViewById<View>(R.id.dialogDate) as TextView
            tvLastMessage = itemView.findViewById<View>(R.id.dialogLastMessage) as TextView
            tvBubble = itemView.findViewById<View>(R.id.dialogUnreadBubble) as TextView
            ivLastMessageUser = itemView.findViewById<View>(R.id.dialogLastMessageUserAvatar) as ImageView
            ivAvatar = itemView.findViewById<View>(R.id.dialogAvatar) as ImageView
            dividerContainer = itemView.findViewById<View>(R.id.dialogDividerContainer) as ViewGroup
            divider = itemView.findViewById<View>(R.id.dialogDivider)

        }

        private fun applyStyle() {
            if (dialogStyle != null) {
                //Texts
                if (tvName != null) {
                    tvName!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, dialogStyle!!.dialogTitleTextSize.toFloat())
                }

                if (tvLastMessage != null) {
                    tvLastMessage!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, dialogStyle!!.dialogMessageTextSize.toFloat())
                }

                if (tvDate != null) {
                    tvDate!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, dialogStyle!!.dialogDateSize.toFloat())
                }

                //Divider
                if (divider != null)
                    divider!!.setBackgroundColor(dialogStyle!!.dialogDividerColor)
                if (dividerContainer != null)
                    dividerContainer!!.setPadding(dialogStyle!!.dialogDividerLeftPadding, 0,
                            dialogStyle!!.dialogDividerRightPadding, 0)
                //Avatar
                if (ivAvatar != null) {
                    ivAvatar!!.getLayoutParams().width = dialogStyle!!.dialogAvatarWidth
                    ivAvatar!!.getLayoutParams().height = dialogStyle!!.dialogAvatarHeight
                }

                //Last message user avatar
                if (ivLastMessageUser != null) {
                    ivLastMessageUser!!.getLayoutParams().width = dialogStyle!!.dialogMessageAvatarWidth
                    ivLastMessageUser!!.getLayoutParams().height = dialogStyle!!.dialogMessageAvatarHeight
                }

                //Unread bubble
                if (tvBubble != null) {
                    val bgShape = tvBubble!!.getBackground() as GradientDrawable
                    bgShape.setColor(dialogStyle!!.dialogUnreadBubbleBackgroundColor)
                    tvBubble!!.setVisibility(if (dialogStyle!!.isDialogDividerEnabled) VISIBLE else GONE)
                    tvBubble!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, dialogStyle!!.dialogUnreadBubbleTextSize.toFloat())
                    tvBubble!!.setTextColor(dialogStyle!!.dialogUnreadBubbleTextColor)
                    tvBubble!!.setTypeface(tvBubble!!.getTypeface(), dialogStyle!!.dialogUnreadBubbleTextStyle)
                }
            }
        }


        private fun applyDefaultStyle() {
            if (dialogStyle != null) {
                if (root != null) {
                    root!!.setBackgroundColor(dialogStyle!!.dialogItemBackground)
                }

                if (tvName != null) {
                    tvName!!.setTextColor(dialogStyle!!.dialogTitleTextColor)
                    tvName!!.setTypeface(Typeface.DEFAULT, dialogStyle!!.dialogTitleTextStyle)
                }

                if (tvDate != null) {
                    tvDate!!.setTextColor(dialogStyle!!.dialogDateColor)
                    tvDate!!.setTypeface(Typeface.DEFAULT, dialogStyle!!.dialogDateStyle)
                }

                if (tvLastMessage != null) {
                    tvLastMessage!!.setTextColor(dialogStyle!!.dialogMessageTextColor)
                    tvLastMessage!!.setTypeface(Typeface.DEFAULT, dialogStyle!!.dialogMessageTextStyle)
                }
            }
        }

        private fun applyUnreadStyle() {
            if (dialogStyle != null) {
                if (root != null) {
                    root!!.setBackgroundColor(dialogStyle!!.dialogUnreadItemBackground)
                }

                if (tvName != null) {
                    tvName!!.setTextColor(dialogStyle!!.dialogUnreadTitleTextColor)
                    tvName!!.setTypeface(Typeface.DEFAULT, dialogStyle!!.dialogUnreadTitleTextStyle)
                }

                if (tvDate != null) {
                    tvDate!!.setTextColor(dialogStyle!!.dialogUnreadDateColor)
                    tvDate!!.setTypeface(Typeface.DEFAULT, dialogStyle!!.dialogUnreadDateStyle)
                }

                if (tvLastMessage != null) {
                    tvLastMessage!!.setTextColor(dialogStyle!!.dialogUnreadMessageTextColor)
                    tvLastMessage!!.setTypeface(Typeface.DEFAULT, dialogStyle!!.dialogUnreadMessageTextStyle)
                }
            }
        }


        override fun onBind(dialog: DIALOG) {
            if (dialog.getUnreadCount() > 0) {
                applyUnreadStyle()
            } else {
                applyDefaultStyle()
            }

            //Set Name
            tvName!!.setText(dialog.getDialogName())

            //Set Date
            var formattedDate: String? = null
            val lastMessageDate = dialog.getLastMessage().getCreatedAt()
            if (datesFormatter != null) formattedDate = datesFormatter!!.format(lastMessageDate)
            tvDate!!.setText(if (formattedDate == null)
                getDateString(lastMessageDate)
            else
                formattedDate)

            //Set Dialog avatar
            if (imageLoader != null) {
                imageLoader!!.loadImage(ivAvatar, dialog.getDialogPhoto())
            }

            //Set Last message user avatar
            if (imageLoader != null) {
                imageLoader!!.loadImage(ivLastMessageUser, dialog.getLastMessage().getUser().getAvatar())
            }
            ivLastMessageUser!!.setVisibility(if (dialogStyle!!.isDialogMessageAvatarEnabled && dialog.getUsers().size > 1)
                VISIBLE
            else
                GONE)

            //Set Last message text
            tvLastMessage!!.setText(dialog.getLastMessage().getText())

            //Set Unread message count bubble
            tvBubble!!.setText(dialog.getUnreadCount().toString())
            tvBubble!!.setVisibility(if (dialogStyle!!.isDialogUnreadBubbleEnabled && dialog.getUnreadCount() > 0)
                VISIBLE
            else
                GONE)

            container.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    if (onDialogClickListener != null) {
                        onDialogClickListener!!.onDialogClick(dialog)
                    }
                    if (onDialogViewClickListener != null) {
                        onDialogViewClickListener!!.onDialogViewClick(view, dialog)
                    }
                }
            })


            container.setOnLongClickListener(object : View.OnLongClickListener {
                override fun onLongClick(view: View): Boolean {
                    if (onLongItemClickListener != null) {
                        onLongItemClickListener!!.onDialogLongClick(dialog)
                    }
                    if (onDialogViewLongClickListener != null) {
                        onDialogViewLongClickListener!!.onDialogViewLongClick(view, dialog)
                    }
                    return onLongItemClickListener != null || onDialogViewLongClickListener != null
                }
            })
        }

        protected fun getDateString(date: Date): String {
            return DateFormatter.format(date, DateFormatter.Template.TIME)
        }

        protected fun getDialogStyle(): DialogListStyle? {
            return dialogStyle
        }

        fun setDialogStyle(dialogStyle: DialogListStyle?) {
            this.dialogStyle = dialogStyle
            applyStyle()
        }
    }
}
