package defpackage;

import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.beken.beken_ota.R$id;
import com.beken.beken_ota.R$layout;
import com.beken.beken_ota.R$string;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ra0 extends BaseAdapter {
    private ArrayList a = new ArrayList();
    private LayoutInflater b;

    private class b {
        TextView a;
        TextView b;

        private b() {
        }
    }

    public ra0(LayoutInflater layoutInflater) {
        this.b = layoutInflater;
    }

    public void a(BluetoothDevice bluetoothDevice) {
        if (this.a.contains(bluetoothDevice)) {
            return;
        }
        this.a.add(bluetoothDevice);
    }

    public void b() {
        this.a.clear();
    }

    public ArrayList c() {
        return this.a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.b.inflate(R$layout.listitem_device, (ViewGroup) null);
            bVar = new b();
            bVar.b = (TextView) view.findViewById(R$id.device_address);
            bVar.a = (TextView) view.findViewById(R$id.device_name);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) this.a.get(i);
        String name = bluetoothDevice.getName();
        if (name == null || name.length() <= 0) {
            bVar.a.setText(R$string.unknown_device);
        } else {
            bVar.a.setText(name);
        }
        bVar.b.setText(bluetoothDevice.getAddress());
        return view;
    }
}
