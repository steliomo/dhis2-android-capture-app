package org.dhis2.common.di

import dagger.Provides
import org.dhis2.data.prefs.PreferenceProvider
import org.dhis2.utils.session.PinModule
import org.dhis2.utils.session.PinPresenter
import org.dhis2.utils.session.PinView
import org.hisp.dhis.android.core.TestingD2Manager

class PinTestingModule(view: PinView) : PinModule(view) {

    @Provides
    override fun providesPresenter(preferenceProvider: PreferenceProvider): PinPresenter {
        return PinPresenter(view, preferenceProvider, TestingD2Manager.getD2())
    }
}