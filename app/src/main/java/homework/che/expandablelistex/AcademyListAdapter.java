package homework.che.expandablelistex;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AcademyListAdapter extends BaseExpandableListAdapter {
    public Context context;
    private LayoutInflater inflater;
    Academy academy;

    public AcademyListAdapter(Context context, Activity activity,Academy academy){
        this.context=context;
        this.academy=academy;
        inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void addStudentGroup(String title){
        academy.addStudentGroup(new StudentGroup(title));
        this.notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return academy.studentGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return academy.studentGroups.get(groupPosition).students.size();
    }

    @Override
    public String getGroup(int groupPosition) {
        return academy.studentGroups.get(groupPosition).getTitle().toString();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        Student student=academy.studentGroups.get(groupPosition).students.get(childPosition);
        String result=student.GetName();
        return result;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View resultView = inflater.inflate(R.layout.group_item_layout, null);
        TextView text = (TextView)resultView.findViewById(R.id.groupName_TV);
        ImageView imageView = (ImageView)resultView.findViewById(R.id.group_IV);

        StudentGroup studentGroup=academy.studentGroups.get(groupPosition);

        text.setText(studentGroup.getTitle().toString());
        imageView.setImageResource(R.drawable.group);

        return resultView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View resulrView = inflater.inflate(R.layout.child_item_layout,null);
        TextView name_TV=(TextView)resulrView.findViewById(R.id.name_TV);
        ImageView male_IV=(ImageView)resulrView.findViewById(R.id.male_IV);

        Student student=academy.studentGroups.get(groupPosition).students.get(childPosition);
        name_TV.setText(student.GetName().toString());
        if(student.getMale().toString().equals("муж")||student.getMale().toString().equals("male")){
            male_IV.setImageResource(R.drawable.male);
        }
        else if(student.getMale().toString().equals("жен")||student.getMale().toString().equals("female")){
            male_IV.setImageResource(R.drawable.female);
        }
        else{
            //
        }

        return resulrView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
