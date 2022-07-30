package me.timschneeberger.rootlessjamesdsp.session.dump

import android.content.Context
import me.timschneeberger.rootlessjamesdsp.session.dump.data.ISessionInfoDump

interface ISessionInfoProvider : IDumpProvider {
    /**
     * Dump audio session information as ISessionInfoDump
     */
    fun dump(context: Context): ISessionInfoDump?

    /**
     * Dump audio session information to string for debug purposes
     */
    override fun dumpString(context: Context): String
}