package com.freehugs.navigation2

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    //FrameLayout 등록하기
    private val fl: FrameLayout by lazy {
        findViewById(R.id.mainFragment)
    }

    //BottomNavigationView 등록하기
    private val bn: BottomNavigationView by lazy {
        findViewById(R.id.bottomNavigationView)
    }

    //ActivityLifecycle(생명주기) 시작
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //앱 실행 시 시작화면 설정하기 - TicketFragment로 시작
        supportFragmentManager.beginTransaction().add(fl.id, TicketFragment()).commit()

        //해당 id값을 가진 곳을 누르면 해당 페이지로 연결
        bn.setOnItemSelectedListener  {
            changeFragment(
                when (it.itemId) {
                    R.id.navMusicwork -> MusicworkFragment()
                    R.id.navSchedule -> ScheduleFragment()
                    R.id.navTicket -> TicketFragment()
                    R.id.navData -> DataFragment()
                    R.id.navMypage -> MypageFragment()
                    else -> TicketFragment()
                }
            )
            true
        }
    }

    //Fragment를 이용해 BottomNavigation 클릭 시 화면이동 시키기
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(fl.id, fragment).commit()
    }
}