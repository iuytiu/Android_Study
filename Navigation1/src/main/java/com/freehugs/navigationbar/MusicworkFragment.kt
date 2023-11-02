package com.freehugs.navigationbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class MusicworkFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_musicwork, container, false)

        //뮤직워크페이지에서 NavScheduleBtn을 눌렀을 때 스케줄페이지 이동
        view.findViewById<Button>(R.id.NavScheduleBtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_musicworkFragment_to_scheduleFragment)
        }

        //뮤직워크페이지에서 NavTicketBtn을 눌렀을 때 스케줄페이지 이동
        view.findViewById<Button>(R.id.NavTicketBtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_musicworkFragment_to_ticketFragment)
        }

        //뮤직워크페이지에서 NavDataBtn을 눌렀을 때 데이터페이지로 이동
        view.findViewById<Button>(R.id.NavDataBtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_musicworkFragment_to_dataFragment)
        }

        //뮤직워크페이지에서 NavMypageBtn을 눌렀을 때 마이페이지로 이동
        view.findViewById<Button>(R.id.NavMypageBtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_musicworkFragment_to_mypageFragment)
        }

        return view
    }
}