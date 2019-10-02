package com.devdream.cookall.chat

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet

import com.stfalcon.chatkit.R
import com.stfalcon.chatkit.commons.Style

internal class DialogListStyle private constructor(context: Context, attrs: AttributeSet) : Style(context, attrs) {

    var dialogTitleTextColor: Int = 0
        private set
    var dialogTitleTextSize: Int = 0
        private set
    var dialogTitleTextStyle: Int = 0
        private set
    var dialogUnreadTitleTextColor: Int = 0
        private set
    var dialogUnreadTitleTextStyle: Int = 0
        private set

    var dialogMessageTextColor: Int = 0
        private set
    var dialogMessageTextSize: Int = 0
        private set
    var dialogMessageTextStyle: Int = 0
        private set
    var dialogUnreadMessageTextColor: Int = 0
        private set
    var dialogUnreadMessageTextStyle: Int = 0
        private set

    var dialogDateColor: Int = 0
        private set
    var dialogDateSize: Int = 0
        private set
    var dialogDateStyle: Int = 0
        private set
    var dialogUnreadDateColor: Int = 0
        private set
    var dialogUnreadDateStyle: Int = 0
        private set

    var isDialogUnreadBubbleEnabled: Boolean = false
        private set
    var dialogUnreadBubbleTextColor: Int = 0
        private set
    var dialogUnreadBubbleTextSize: Int = 0
        private set
    var dialogUnreadBubbleTextStyle: Int = 0
        private set
    var dialogUnreadBubbleBackgroundColor: Int = 0
        private set

    var dialogAvatarWidth: Int = 0
        private set
    var dialogAvatarHeight: Int = 0
        private set

    var isDialogMessageAvatarEnabled: Boolean = false
        private set
    var dialogMessageAvatarWidth: Int = 0
        private set
    var dialogMessageAvatarHeight: Int = 0
        private set

    var isDialogDividerEnabled: Boolean = false
        private set
    var dialogDividerColor: Int = 0
        private set
    var dialogDividerLeftPadding: Int = 0
        private set
    var dialogDividerRightPadding: Int = 0
        private set

    var dialogItemBackground: Int = 0
        private set
    var dialogUnreadItemBackground: Int = 0
        private set

    companion object {

        fun parse(context: Context, attrs: AttributeSet): DialogListStyle {
            val style = DialogListStyle(context, attrs)

            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.DialogsList)

            //Item background
            style.dialogItemBackground = typedArray.getColor(
                    R.styleable.DialogsList_dialogItemBackground,
                    style.getColor(R.color.transparent))
            style.dialogUnreadItemBackground = typedArray.getColor(
                    R.styleable.DialogsList_dialogUnreadItemBackground,
                    style.getColor(R.color.transparent))

            //Title text
            style.dialogTitleTextColor = typedArray.getColor(
                    R.styleable.DialogsList_dialogTitleTextColor,
                    style.getColor(R.color.dialog_title_text))
            style.dialogTitleTextSize = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogTitleTextSize,
                    context.resources.getDimensionPixelSize(R.dimen.dialog_title_text_size))
            style.dialogTitleTextStyle = typedArray.getInt(
                    R.styleable.DialogsList_dialogTitleTextStyle, Typeface.NORMAL)

            //Title unread text
            style.dialogUnreadTitleTextColor = typedArray.getColor(
                    R.styleable.DialogsList_dialogUnreadTitleTextColor,
                    style.getColor(R.color.dialog_title_text))
            style.dialogUnreadTitleTextStyle = typedArray.getInt(
                    R.styleable.DialogsList_dialogUnreadTitleTextStyle, Typeface.NORMAL)

            //Message text
            style.dialogMessageTextColor = typedArray.getColor(
                    R.styleable.DialogsList_dialogMessageTextColor,
                    style.getColor(R.color.dialog_message_text))
            style.dialogMessageTextSize = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogMessageTextSize,
                    context.resources.getDimensionPixelSize(R.dimen.dialog_message_text_size))
            style.dialogMessageTextStyle = typedArray.getInt(
                    R.styleable.DialogsList_dialogMessageTextStyle, Typeface.NORMAL)

            //Message unread text
            style.dialogUnreadMessageTextColor = typedArray.getColor(
                    R.styleable.DialogsList_dialogUnreadMessageTextColor,
                    style.getColor(R.color.dialog_message_text))
            style.dialogUnreadMessageTextStyle = typedArray.getInt(
                    R.styleable.DialogsList_dialogUnreadMessageTextStyle, Typeface.NORMAL)

            //Date text
            style.dialogDateColor = typedArray.getColor(R.styleable.DialogsList_dialogDateColor,
                    style.getColor(R.color.dialog_date_text))
            style.dialogDateSize = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogDateSize,
                    context.resources.getDimensionPixelSize(R.dimen.dialog_date_text_size))
            style.dialogDateStyle = typedArray.getInt(
                    R.styleable.DialogsList_dialogDateStyle, Typeface.NORMAL)

            //Date unread text
            style.dialogUnreadDateColor = typedArray.getColor(
                    R.styleable.DialogsList_dialogUnreadDateColor,
                    style.getColor(R.color.dialog_date_text))
            style.dialogUnreadDateStyle = typedArray.getInt(
                    R.styleable.DialogsList_dialogUnreadDateStyle, Typeface.NORMAL)

            //Unread bubble
            style.isDialogUnreadBubbleEnabled = typedArray.getBoolean(
                    R.styleable.DialogsList_dialogUnreadBubbleEnabled, true)
            style.dialogUnreadBubbleBackgroundColor = typedArray.getColor(
                    R.styleable.DialogsList_dialogUnreadBubbleBackgroundColor,
                    style.getColor(R.color.dialog_unread_bubble))

            //Unread bubble text
            style.dialogUnreadBubbleTextColor = typedArray.getColor(
                    R.styleable.DialogsList_dialogUnreadBubbleTextColor,
                    style.getColor(R.color.dialog_unread_text))
            style.dialogUnreadBubbleTextSize = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogUnreadBubbleTextSize,
                    context.resources.getDimensionPixelSize(
                            R.dimen.dialog_unread_bubble_text_size))
            style.dialogUnreadBubbleTextStyle = typedArray.getInt(
                    R.styleable.DialogsList_dialogUnreadBubbleTextStyle, Typeface.NORMAL)

            //Avatar
            style.dialogAvatarWidth = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogAvatarWidth,
                    context.resources.getDimensionPixelSize(R.dimen.dialog_avatar_width))
            style.dialogAvatarHeight = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogAvatarHeight,
                    context.resources.getDimensionPixelSize(R.dimen.dialog_avatar_height))

            //Last message avatar
            style.isDialogMessageAvatarEnabled = typedArray.getBoolean(
                    R.styleable.DialogsList_dialogMessageAvatarEnabled, true)
            style.dialogMessageAvatarWidth = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogMessageAvatarWidth,
                    context.resources.getDimensionPixelSize(
                            R.dimen.dialog_last_message_avatar_width))
            style.dialogMessageAvatarHeight = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogMessageAvatarHeight,
                    context.resources.getDimensionPixelSize(
                            R.dimen.dialog_last_message_avatar_height))

            //Divider
            style.isDialogDividerEnabled = typedArray.getBoolean(
                    R.styleable.DialogsList_dialogDividerEnabled, true)
            style.dialogDividerColor = typedArray.getColor(
                    R.styleable.DialogsList_dialogDividerColor, style.getColor(R.color.dialog_divider))
            style.dialogDividerLeftPadding = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogDividerLeftPadding,
                    context.resources.getDimensionPixelSize(
                            R.dimen.dialog_divider_margin_left))
            style.dialogDividerRightPadding = typedArray.getDimensionPixelSize(
                    R.styleable.DialogsList_dialogDividerRightPadding,
                    context.resources.getDimensionPixelSize(R.dimen.dialog_divider_margin_right))

            typedArray.recycle()

            return style
        }
    }
}
