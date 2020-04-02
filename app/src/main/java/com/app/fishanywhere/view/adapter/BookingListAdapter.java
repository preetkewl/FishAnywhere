package com.app.fishanywhere.view.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.fishanywhere.R;
import com.app.fishanywhere.misc.ProgressHUD;
import com.app.fishanywhere.misc.Utils;
import com.app.fishanywhere.model.Callbacks.GetBookingRecordCallback;
import com.app.fishanywhere.model.Callbacks.GetBookingStatusCallback;
import com.app.fishanywhere.presenter.BookingPresenter;
import com.app.fishanywhere.view.interfaces.BookingInterface;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.bookingrecordVH>  implements BookingInterface {



    private Context context;
    private ArrayList<GetBookingRecordCallback> recordCallback = new ArrayList<>();
    private BookingPresenter bookingPresenter;
    private String userId="";

    private ProgressHUD progressHUD;
    private BookingPresenter bookingPresenterPre;
    private RecyclerView rvBookingList;
    private BookingListAdapter bookingListAdapter;



    public BookingListAdapter(Context ctx, ArrayList<GetBookingRecordCallback> recordCallback,
                              String userId, BookingPresenter bookingPresenter,
                              RecyclerView rvBookingList,
                              BookingListAdapter bookingListAdapter) {
        this.context = ctx;
        this.recordCallback = recordCallback;
        this.bookingPresenter = new BookingPresenter(context, this);
        this.userId= userId;
        this.bookingPresenterPre= bookingPresenter;
        this.rvBookingList= rvBookingList;
        this.bookingListAdapter= bookingListAdapter;
    }

    @NonNull
    @Override
    public bookingrecordVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_bookings_list_item, viewGroup, false);
        return new bookingrecordVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookingrecordVH bookingrecordVH, int postion) {

        String firstname = "";
        String lastname = "";
        String bookingrate = "";
        String guestno = "";
        String status = "";
        String bookingID="";

        if (recordCallback != null && recordCallback.size() > 0) {
            GetBookingRecordCallback data = recordCallback.get(postion);
            if (data != null) {
                if (data.getCustomerFirstName() != null && !data.getCustomerFirstName().isEmpty()) {
                    firstname = data.getCustomerFirstName();
                    if (data.getCustomerLastName() != null && !data.getCustomerLastName().isEmpty()) {
                        lastname = data.getCustomerLastName();
                    }
                    bookingrecordVH.tvUsername.setText(data.bookingProduct);
                }
                if (data.getBookingCost() != null && !data.getBookingCost().isEmpty()) {
                    bookingrate = data.getBookingCost();
                    bookingrecordVH.tvPrice.setText("USD $" + bookingrate);
                }
                try {
                    if (data.getBookingPersons() != null && data.getBookingPersons().size() == 0) {
                        bookingrecordVH.tvIncludes.setText("Includes " + "0" + " Guests");
                    } else if (data.getBookingPersons() != null && data.getBookingPersons().get(0) != null && data.getBookingPersons().size() > 0) {
                        guestno = String.valueOf(data.getBookingPersons().get(0));
                        bookingrecordVH.tvIncludes.setText("Includes " + guestno + " Guests");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                $100 per additional guest

                if (data.getWc_booking_has_persons() == 0){
                                    bookingrecordVH.tvAdditionalCost.setText("Max " + data.getWc_booking_max_persons_group() + " Guests");

                } else {
                                    bookingrecordVH.tvAdditionalCost.setText("+ $" + data.getPrice_for_each_additional_person() + "per additional guest. Max " + data.getWc_booking_max_persons_group() + " Guests");

                }

                bookingrecordVH.tvCreatedAt.setText("Trip date " + data.bookingStart);

                bookingrecordVH.tvBookingID.setText("Booking ID: #"+ data.bookingId);

                if (data.getStatus() != null) {
                    if (data.getStatus().equals("pending-confirmation")) {
                        bookingrecordVH.acceptReject.setVisibility(View.VISIBLE);
                        bookingrecordVH.bookingConfirm.setVisibility(View.GONE);
                        bookingrecordVH.other.setVisibility(View.GONE);


                        if(data.getBookingId()!=null) {
                            bookingID = String.valueOf(data.getBookingId());
                        }
                        status = data.getStatus();
                        String finalBookingID = bookingID;
                        String finalStatus = status;
                        bookingrecordVH.llAccept.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                try {
                                    showPogress();
                                    bookingPresenter.getBookingAccept(userId, finalBookingID, finalStatus,
                                            bookingPresenter,rvBookingList, bookingListAdapter,context);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        });

                        bookingrecordVH.llReject.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                try {
                                    showPogress();
                                    bookingPresenter.getBookingReject(userId, finalBookingID, finalStatus,
                                            bookingPresenter,rvBookingList, bookingListAdapter,context);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                    } else if (data.getStatus().equals("confirmed")) {
                        bookingrecordVH.bookingConfirm.setVisibility(View.VISIBLE);
                        bookingrecordVH.acceptReject.setVisibility(View.GONE);
                        bookingrecordVH.other.setVisibility(View.GONE);


                    } else if (data.getStatus().equals("unpaid") || data.getStatus().equals("paid") ||
                            data.getStatus().equals("cancelled") || data.getStatus().equals("complete")) {
                        bookingrecordVH.other.setVisibility(View.VISIBLE);
                        bookingrecordVH.bookingConfirm.setVisibility(View.GONE);
                        bookingrecordVH.acceptReject.setVisibility(View.GONE);

                        status = data.getStatus();
                        bookingrecordVH.tvStatusOther.setText(status.toUpperCase());

                    }

                }

            }

        }


    }


    @Override
    public int getItemCount() {
        return recordCallback.size();
    }

    public void updateList(ArrayList<GetBookingRecordCallback> list) {
        this.recordCallback = list;
        notifyDataSetChanged();
    }

    @Override
    public void getBokingList(ArrayList<GetBookingRecordCallback> recordCallback) {
        hideProgress();
        if(recordCallback!=null && recordCallback.size()>0){
            this.recordCallback= recordCallback;
            rvBookingList.getLayoutManager().scrollToPosition(0);
            notifyDataSetChanged();
        }
        else{
            Utils.showToast(context,"Something went wrong!");

        }


    }

    @Override
    public void getBoookingAccept(GetBookingStatusCallback data,
                                  String userId,
                                  BookingPresenter bookingPresenter,
                                  RecyclerView rvBookingList,
                                  BookingListAdapter bookingListAdapter, Context context) {
        if(data!=null && data.getStatus()!=null && !data.getStatus().isEmpty() && data.getStatus().equalsIgnoreCase("confirmed")&&
                data.getType()!=null && !data.getType().isEmpty() && data.getType().equalsIgnoreCase("success")){
            try {
                showPogress();
                this.bookingPresenter.getBookingRecordValue(userId);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public void getBoookingReject(GetBookingStatusCallback data, String userId, BookingPresenter bookingPresenter, RecyclerView rvBookingList, BookingListAdapter bookingListAdapter, Context context) {
        hideProgress();
        if(data!=null && data.getStatus()!=null && !data.getStatus().isEmpty() && data.getStatus().equalsIgnoreCase("cancelled")&&
                data.getType()!=null && !data.getType().isEmpty() && data.getType().equalsIgnoreCase("success")){
            try {
                showPogress();
                this.bookingPresenter.getBookingRecordValue(userId);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }




    @Override
    public void start() {

    }

    @Override
    public void finish(String message) {
        hideProgress();
        Utils.showToast(context,message);
    }

    @Override
    public void failed(String message) {
        hideProgress();
        Utils.showToast(context,message);
    }

    public class bookingrecordVH extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_includes)
        TextView tvIncludes;
        @BindView(R.id.tv_additional_cost)
        TextView tvAdditionalCost;
        @BindView(R.id.rl_edit)
        RelativeLayout rlEdit;

        @BindView(R.id.booking_confirm)
        LinearLayout bookingConfirm;
        @BindView(R.id.accept_reject)
        LinearLayout acceptReject;
        @BindView(R.id.other)
        LinearLayout other;

        @BindView(R.id.ll_accept)
        LinearLayout llAccept;
        @BindView(R.id.ll_reject)
        LinearLayout llReject;

        @BindView(R.id.tv_status_other)
        TextView tvStatusOther;

        @BindView(R.id.tvCreatedAt)
        TextView tvCreatedAt;

        @BindView(R.id.tvBookingID)
        TextView tvBookingID;

        public bookingrecordVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setIsRecyclable(false);
        }
    }


    void showPogress() {
        progressHUD = ProgressHUD.show(context, "", true, false, new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                // TODO Auto-generated method stub
            }
        });
    }

    void hideProgress() {
        if (progressHUD != null && progressHUD.isShowing()) {
            progressHUD.dismiss();
        }
    }
}
