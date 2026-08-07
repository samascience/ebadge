package defpackage;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.legend.smartwatch.electronicbadge.android.R;
import java.util.List;
import xfkj.fitpro.model.ContractModel;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SynContractsActivity;

/* JADX INFO: loaded from: classes4.dex */
public class a40 extends pg {
    TextView c;
    TextView d;
    TextView e;
    private boolean f;

    public a40(final View view, final List list) {
        super(view);
        this.f = zm1.O();
        this.c = (TextView) view.findViewById(R.id.tv_name);
        this.d = (TextView) view.findViewById(R.id.tv_number);
        TextView textView = (TextView) view.findViewById(R.id.tv_sos);
        this.e = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: z30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.d(list, view, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(List list, View view, View view2) {
        ContractModel contractModel = (ContractModel) list.get(getAbsoluteAdapterPosition());
        Log.i(this.b, "sos phone number:" + contractModel.toString());
        if (pv2.b(contractModel.getPhoneNumber(), zm1.p())) {
            return;
        }
        ((SynContractsActivity) view.getContext()).u0(contractModel.getPhoneNumber());
    }

    @Override // defpackage.pg
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void a(ContractModel contractModel, int i) {
        this.c.setText(contractModel.getContractName());
        this.d.setText(contractModel.getPhoneNumber());
        this.e.setVisibility(this.f ? 0 : 8);
        this.e.setSelected(false);
        this.e.setSelected(pv2.b(contractModel.getPhoneNumber(), zm1.p()));
    }
}
