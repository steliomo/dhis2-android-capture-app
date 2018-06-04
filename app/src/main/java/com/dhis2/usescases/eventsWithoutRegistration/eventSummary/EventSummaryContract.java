package com.dhis2.usescases.eventsWithoutRegistration.eventSummary;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.dhis2.data.forms.FormSectionViewModel;
import com.dhis2.data.forms.dataentry.fields.FieldViewModel;
import com.dhis2.usescases.general.AbstractActivityContracts;

import org.hisp.dhis.android.core.event.EventModel;
import org.hisp.dhis.android.core.program.ProgramModel;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Cristian on 01/03/2018.
 *
 */

public class EventSummaryContract {

    public interface View extends AbstractActivityContracts.View {

        void setProgram(@NonNull ProgramModel program);

        void onEventSections(List<FormSectionViewModel> formSectionViewModels);

        @NonNull
        Consumer<List<FieldViewModel>> showFields(String sectionUid);

        void onStatusChanged(EventModel event);

        void setActionButton(EventModel eventModel);
    }

    public interface Presenter extends AbstractActivityContracts.Presenter {
        void init(@NonNull EventSummaryContract.View view, @NonNull String programId, @NonNull String eventId);

        void onBackClick();

        void getSectionCompletion(@Nullable String sectionUid);

        void onDoAction();
    }

    public interface Interactor extends AbstractActivityContracts.Interactor {

        void init(@NonNull EventSummaryContract.View view, @NonNull String programId, @NonNull String eventId);

        void getProgram(@NonNull String programUid);

        void getEventSections(@NonNull String programId);

        void getSectionCompletion(@Nullable String sectionUid);

        void onDoAction();
    }
}
