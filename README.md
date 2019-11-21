---
tags: app teaching
disqus: hackmd
slideOptions:
transition: slide

---

# checkbox

---

# Use Listview & CheckTextView & Alertdialog

`---`

劉冠呈 資工三Ｂ

`<!-- .slide: data-transition="zoom" -->`

---

# 可X可熟x紅茶

`<!-- .slide: data-transition="zoom" -->`

---

## 成品

![](https://i.imgur.com/5GWBruM.png)

---

## STEPT 1 Create a listview

---

![](https://i.imgur.com/MDSqhwB.png)

---

## STPET 2 Create a new xml layout

---

![](https://i.imgur.com/dXG6xFq.jpg)

---

## STEPT 3 Create a CheckTextView

---

![](https://i.imgur.com/jBJYo6x.png)

---

## STEPT 4 Write java code!!

---

### 宣告變數（MainActivity.java）

---

![](https://i.imgur.com/NqnmlHx.png)

--- 

## 設定有幾個item（MainActivity.java）

---

![](https://i.imgur.com/be7cnBC.png)

---

## 設定 item 的點擊事件（MainActivity.java）

---

![](https://i.imgur.com/2LYi0Ua.png)

---

## 設定 Adapter （適配器）

---

## 什麼是 Adapter?

---

「android.widget.Adapter」是一個Java介面(interface)，是一個規範Adapter應該實作什麼方法的規範，也可說是一個家族的最高層成員，所有在它底下的類別都要實作它所訂定的方法，如getCount方法可取得清單中的項目數量、getView方法可得到特定展示的元件(View)等。

---

## 還是不懂？

---

![](https://i.imgur.com/uxVprFA.png)

---

- List_adapter.java

public class ListAdepter extends BaseAdapter {
private Activity activity;
private List<String> mList;

private static LayoutInflater inflater = null;

public ListAdepter(activity a, List<String> list)
{
activity = a;
mList = list;
inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

public int getCount()
{
return mList.size();
}

public Object getItem(int position)
{
return position;
}

public long getItemId(int position)
{
return position;
}

public View getView(int position, View convertView, ViewGroup parent)
{
View vi = convertView;
if(convertView==null)
{
vi = inflater.inflate(R.layout.listview_item, null);
}

CheckedTextView chkBshow = (CheckedTextView) vi.findViewById(R.id.check);

chkBshow.setText(mList.get(position).toString());

return vi;
}
}

---

## 什麼是Alertdialog?

---

![](https://i.imgur.com/8ajLfHG.png)

---

## 設定 alertdialog

![](https://i.imgur.com/fwrMw7P.png)

---

- MainActivity.java



public class MainActivity extends AppCompatActivity {

List<String> list; // 用來設定商品項目
ListView listview;
List<Boolean> listShow;    // 這個用來記錄哪幾個 item 是被打勾的
int total = 0; // 用來記錄你總共花多少錢
Button button;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
listview = findViewById(R.id.ListView);
listShow = new ArrayList<Boolean>();

list = new ArrayList<String>();

list.add("熟x紅茶  50元");
listShow.add(false);

list.add("熟x冷露  50元");
listShow.add(false);

list.add("春x綠茶  50元");
listShow.add(false);

list.add("春x冰茶  50元");
listShow.add(false);

list.add("白x歐雷  50元");
listShow.add(false);

list.add("春x紅茶  50元");
listShow.add(false);

list.add("春x冷露  50元");
listShow.add(false);

listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
CheckedTextView chkItem = v.findViewById(R.id.check);
chkItem.setChecked(!chkItem.isChecked());

if (listShow.get(position) == false) {
listShow.set(position, true);
total += 50;
} else {
listShow.set(position, false);
total -= 50;

}

listShow.set(position, chkItem.isChecked());

}
});

ListAdepter adapterItem = new ListAdepter(this, list);
listview.setAdapter(adapterItem);

button = findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
new AlertDialog.Builder(MainActivity.this)
.setTitle("是否要給拎北錢")
.setMessage("給拎北錢" + total)
.setPositiveButton("給拎北錢", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
return;
}
})
.setNeutralButton("我再想想", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
return;
}
}).show();
}
});
}
}








